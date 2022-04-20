package com.project.ApiProject;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;
import lombok.Data;


@Entity
@Data
public class Role extends AbstractPersistable<Long> {

    private String role;

    public Role(){
        
    }

    public Role(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }

    public void setRole(String role){
        this.role = role;
    }
}
