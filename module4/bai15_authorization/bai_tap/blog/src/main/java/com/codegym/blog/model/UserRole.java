package com.codegym.blog.model;
import javax.persistence.*;

@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userRoleid;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    @ManyToOne(targetEntity = Role.class)
    @JoinColumn(name = "roleId", referencedColumnName = "roleId")
    private Role role;

    public UserRole() {
    }

    public int getUserRoleid() {
        return userRoleid;
    }

    public void setUserRoleid(int userRoleid) {
        this.userRoleid = userRoleid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}