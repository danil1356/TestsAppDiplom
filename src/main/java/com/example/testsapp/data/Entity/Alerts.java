package com.example.testsapp.data.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "alerts")
@Getter
@Setter
@ToString
public class Alerts extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "user_login")
    private String user_login;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private Users user_id;

    @ManyToOne
    @JoinColumn(name = "user_sender_id", nullable = false, referencedColumnName = "id")
    private Users user_sender_id;

    @Column(name = "is_hide")
    private Boolean is_hide;

    public Alerts(){
    };

    public Alerts(Long id){
        super(id);
    }

    public Alerts(Long id, String name, String user_login, Users user, Users userSender, Boolean is_hide){
        super(id);
        this.name =name;
        this.user_login = user_login;
        this.user_id = user;
        this.user_sender_id = userSender;
        this.is_hide = is_hide;
    }
}
