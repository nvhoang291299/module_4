package com.example.authentication.model;

import javax.persistence.*;

@Entity
@Table(name = "User_Role", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "USER_ROLE_UK", columnNames = { "User_Id", "Role_Id" }) })
public class UserRole {

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "User_Id", nullable = false)
    private Users users;

    @ManyToOne
    @JoinColumn(name = "Role_Id", nullable = false)
    private Roles roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getAppUser() {
        return users;
    }

    public void setAppUser(Users users) {
        this.users = users;
    }

    public Roles getAppRole() {
        return roles;
    }

    public void setAppRole(Roles roles) {
        this.roles = roles;
    }

}