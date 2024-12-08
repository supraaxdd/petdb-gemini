package com.supra.petdbgemini.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    private String username; // Email as username

    @JsonIgnore // Exclude password from API responses
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean locked;

    private String firstName;

    private String lastName;

    private String county;

    public enum Role {
        ADMIN,
        USER
    }
}