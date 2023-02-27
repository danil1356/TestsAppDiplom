package com.example.testsapp.data.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
public class Users  extends BaseEntity{

    @Column (name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "second_name", nullable = false)
    private String second_name;

    @Column(name = "mail", nullable = false)
    private String mail;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private Set<Roles> rolesSet;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "user")
    private Set<Tests> testsSet;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "user")
    private Set<Statistics> statistic;

    public Users() {
    }

    public Users(Long id) {
        super(id);
    }

    public Users(Long id, String login, String password, String name, String second_name, String mail, Status status) {
        super(id);
        this.login = login;
        this.password = password;
        this.name = name;
        this.second_name = second_name;
        this.mail = mail;
        this.status = status;
    }
}
