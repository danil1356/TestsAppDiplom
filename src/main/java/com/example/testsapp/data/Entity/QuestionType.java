package com.example.testsapp.data.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "question_type")
@Getter
@Setter
@ToString
public class QuestionType extends BaseEntity{

    @Column(name = "type", nullable = false)
    private String type;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "questionType")
    private Set<Questions> questionsSet;

    public QuestionType(Long id) {
        super(id);
    }

    public QuestionType() {
    }

    public QuestionType(Long id, String type) {
        super(id);
        this.type = type;
    }
}
