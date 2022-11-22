package com.fjl.pojo;

import lombok.Data;

@Data
public class loginForm {
    private String username;
    private String password;
    private String type;

    public loginForm(String username, String password, String type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public loginForm() {
    }
}
