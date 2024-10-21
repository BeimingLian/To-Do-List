package org.demo.todo.domain;

public class users {
    private Long id;
    private String userName;
    private String password;
    private String email;

    public Long getUserId() {
        return id;
    }

    public users setUserId(Long userId) {
        this.id = userId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public users setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public users setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public users setEmail(String email) {
        this.email = email;
        return this;
    }
}
