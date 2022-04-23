package com.project.ApiProject;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class UserDto {

    @NotBlank(message = "Enter your firstname")
    private String firstname;

    @NotBlank(message = "Enter your lastname")
    private String lastname;

    @Column(unique = true)
    @NotBlank(message = "Enter your email")
    @Email(message = "Enter valid email address")
    private String email;

    @NotBlank(message = "Enter your password")
    @Length(min = 6, message = "Password needs to be atleast 6 characters long")
    private String password;

    public UserDto(){

    }

    
    public UserDto(String firstname, String lastname, String email, String password){
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

}
