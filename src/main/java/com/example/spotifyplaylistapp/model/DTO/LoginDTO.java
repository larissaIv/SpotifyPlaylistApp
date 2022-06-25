package com.example.spotifyplaylistapp.model.DTO;

import javax.validation.constraints.Size;

public class LoginDTO {

    @Size(min = 3, max = 20)
    private String username;

    @Size(min = 3, max = 20)
    private String password;

    public LoginDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}