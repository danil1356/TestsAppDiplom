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
    private Integer test_result;

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

    public Statistics(Long id, Integer test_result, Tests test, Users user) {
        super(id);
        this.test_result = test_result;
        this.test = test;
        this.user = user;
    }
}
