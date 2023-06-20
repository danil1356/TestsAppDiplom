package com.example.testsapp.data.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "statistics")
@Getter
@Setter
@ToString
public class Statistics extends BaseEntity{

    @Column(name = "test_result", nullable = false)
    private Long test_result;

    @Column(name = "pass_name", nullable = false)
    private String pass_name;

    @ManyToOne
    @JoinColumn(name = "tests_id", nullable = false, referencedColumnName = "id")
    private Tests test;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private Users user;

    public Statistics() {
    }

    public Statistics(Long id) {
        super(id);
    }

    public Statistics(Long id, Long test_result, Tests test, Users user, String pass_name) {
        super(id);
        this.test_result = test_result;
        this.pass_name = pass_name;
        this.test = test;
        this.user = user;
    }
}
