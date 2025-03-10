package com.Food.Food.Delivery.dto;
// DTO Client <-> Controller (DTOs) <-> Service (Domain Models) <-> Repository (Entities)
// helps to binds the external view data with internal data view .
public class AuthRequestDTO {
    private String username; // Changed from 'name' to 'username' to match User entity
    private String lname;
    private String email;
    private String password;

    public AuthRequestDTO() {}

    public AuthRequestDTO(String username, String lname, String email, String password) {
        this.username = username;
        this.lname = lname;
        this.email = email;
        this.password = password;
    }

    public String getUsername() { // Changed from 'getName' to 'getUsername'
        return username;
    }

    public void setUsername(String username) { // Changed from 'setName' to 'setUsername'
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}