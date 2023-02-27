package com.example.testsapp.data.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
@Getter
@Setter
@ToString
public class Roles extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "rolesSet", fetch = FetchType.LAZY)
    private Set<Users> users;

    public Roles() {
    }
    public Roles(Long id) {
        super(id);
    }

    public Roles(Long id, String name) {
        super(id);
        this.name = name;
    }
}
