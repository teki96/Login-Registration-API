package com.project.ApiProject;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.Data;

@Entity
@Data
public class User extends AbstractPersistable<Long> {

    @Column(nullable = false, unique = true, length = 20)
    private String username;
    
    @Column(nullable = false, length = 64)
    private String password;

    public User(){

    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
        )
    private Collection<Role> role;

    public User(String username, String password, Collection<Role> role){
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public void setUsername(String username){
        this.username = username;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public void setRole(Collection<Role> role){
        this.role = role;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public Collection<Role> getRole(){
        return role;
    }

}
