package com.project.ApiProject;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.AbstractPersistable;
import lombok.Data;

@Entity
@Data
public class User extends AbstractPersistable<Long> {

    @NotBlank(message = "Enter your firstname")
    private String firstname;

    @NotBlank(message = "Enter your lastname")
    private String lastname;

    @NotBlank(message = "Enter your email")
    @Email(message = "Enter valid email address")
    private String email;

    @NotBlank(message = "Enter your password")
    @Length(min = 6, message = "Password needs to be atleast 6 characters long")
    private String password;

    @NotBlank(message = "Re-enter your password")
    private String rpassword;
  

    public User(){

    }

    public User(String firstname, String lastname, String email, String password, String rpassword, Collection<Role> role){
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.rpassword = rpassword;
        this.role = role;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
        )
        private Collection<Role> role;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public String getRpassword(){
        return rpassword;
    }

    public Collection<Role> getRole(){
        return role;
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

    public void setRpassword(String rpassword){
        this.rpassword = rpassword;
    }
    
    public void setRole(Collection<Role> role){
        this.role = role;
    }




}
