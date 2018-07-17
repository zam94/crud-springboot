package com.test.code.Model;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name = "USERS")
public class Users extends Base {

    @Size(min = 4, max = 255, message = "Minimum username length: 4 characters")
    @Column(name = "USERNAME")
    private String username;

    @Column(name = "EMAIL")
    private String email;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

