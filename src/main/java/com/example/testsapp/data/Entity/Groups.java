package com.example.testsapp.data.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "groups")
@Getter
@Setter
@ToString
public class Groups extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "groupsSet", fetch = FetchType.LAZY)
    private Set<Users> users;


    public Groups(){

    };

    public Groups(Long id){
        super(id);
    };

    public Groups(Long id, String name){
        super(id);
        this.name = name;
    };
}
