package com.blog.config;

import com.blog.service.CustomerOAuth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.sql.DataSource;

/**
 * Spring Security Configuration
 * http://docs.spring.io/spring-boot/docs/current/reference/html/howto-security.html
 * Switches off Spring Boot automatic security configuration
 */
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AccessDeniedHandler accessDeniedHandler;

    final DataSource dataSource;
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Value("${spring.admin.username}")
    private String adminUsername;

    @Value("${spring.admin.username}")
    private String adminPassword;

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    @Autowired
    public SpringSecurityConfig(AccessDeniedHandler accessDeniedHandler, DataSource dataSource) {
        this.accessDeniedHandler = accessDeniedHandler;
        this.dataSource = dataSource;
    }

    /**
     * HTTPSecurity configurer
     * - roles ADMIN allow to access /admin/**
     * - roles USER allow to access /user/** and /newPost/**
     * - anybody can visit /, /home, /registration, /error, /blog/**, /post/**, /h2-console/**
     * - every other page needs authentication
     * - custom 403 access denied handler
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/images/**").permitAll()
                .antMatchers("/home","/forgot_password/**","/reset_password/**", "/registration", "/error", "/blog/**", "/post/**", "/h2-console/**").permitAll()
                .antMatchers("/newPost/**", "/commentPost/**", "/createComment/**").hasAnyRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home")
                .permitAll()
                .and()
                .oauth2Login()
                	.loginPage("/login")
                    .userInfoEndpoint()
                	.userService(oAuth2UserService)
                .and()
                .successHandler(oAuth2LoginSuccessHandler)
                .and()
                .logout()
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler)
                .and().headers().frameOptions().disable();


    }


    /**
     * Authentication details
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        // Database authentication
        auth.
                jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder());

        // In memory authentication
        auth.inMemoryAuthentication()
                .withUser(adminUsername).password(adminPassword).roles("ADMIN");
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/img/**", "/icon/**");
    }

    /**
     * Configure and return BCrypt password encoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Autowired
    private CustomerOAuth2UserService oAuth2UserService;
    @Autowired
    private OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;
    private OAuth2LoginSuccessHandler login;

}
