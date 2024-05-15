package com.example.taskwebdev.Entity;

import jakarta.persistence.*;
import lombok.Setter;

import java.util.Collection;

@Entity

@Table
@Setter

public class Role {
    @Id
    private Integer roleId;
    @Column(name="role_name", nullable=false,length=100)
    private String roleName;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "roles_users",
            foreignKey = @ForeignKey(name = "FK_roles_rolesID"),
            joinColumns = @JoinColumn(name = "roles_id", referencedColumnName = "id"),
            inverseForeignKey = @ForeignKey(name = "FK_users_usersID"),
            inverseJoinColumns = @JoinColumn(name = "users_id", referencedColumnName = "id"),
            uniqueConstraints = @UniqueConstraint(name = "UNIQUE_roles_users_roleIdUserId",
                    columnNames = {"role_id", "user_id"})
    )
    private Collection<User> user;
}