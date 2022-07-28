package com.reljicd.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "like")
public class Like {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    @NotNull
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "post_id", nullable = false)
    @NotNull
    private Post post;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
