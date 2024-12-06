package com.example.baitapnhomlaptrinhadr_nhd_cosmetic.Chatactivity;

public class UserModel {
    private String userId;
    private String name;
    private String username;
    private String password;

    public UserModel() {
        // Required default constructor for calls to DataSnapshot.getValue(UserModel.class)
    }

    public UserModel(String userId, String name, String username, String password) {
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    // Getters and setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
