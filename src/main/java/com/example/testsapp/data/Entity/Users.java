package com.example.testsapp.data.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
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

    @Column(name = "mail")
    private String mail;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "date_birth")
    private Date dateBirth;

    //роли
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private Set<Roles> rolesSet;

    //группы
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_groups",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "group_id", referencedColumnName = "id")})
    private Set<Groups> groupsSet;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_test",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "test_id", referencedColumnName = "id")})
    private Set<Tests> testsSet;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "user")
    private Set<Statistics> statistic;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "user_id")
    private Set<Alerts> alerts;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "user_sender_id")
    private Set<Alerts> senderAlerts;

    public Users() {
    }

    public Users(Long id) {
        super(id);
    }

    public Users(Long id, String login, String password, String name, String second_name, String mail, Status status, String patronymic, Date dateBirth) {
        super(id);
        this.login = login;
        this.password = password;
        this.name = name;
        this.second_name = second_name;
        this.mail = mail;
        this.status = status;
        this.patronymic = patronymic;
        this.dateBirth = dateBirth;

    }
}
