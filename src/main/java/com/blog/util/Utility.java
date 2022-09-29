package com.blog.util;

import javax.servlet.http.HttpServletRequest;

public class Utility {
    public static String getSiteURL(HttpServletRequest request){
        String site=request.getRequestURL().toString();
        return site.replace(request.getServletPath(),"");
    }
}
