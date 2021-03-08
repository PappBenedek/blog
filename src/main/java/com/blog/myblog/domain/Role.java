package com.blog.myblog.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Roles")
public class Role {
    @GeneratedValue
    @Id
    private long id;
    private String role;
    @ManyToMany
    private Set<User> users = new HashSet<User>();


    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public Set<User> getUsers() { return users; }
    public void setUsers(Set<User> users) { this.users = users; }




}
