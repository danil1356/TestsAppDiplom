package com.example.testsapp.data.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "questions")
@Getter
@Setter
@ToString
public class Questions extends BaseEntity {

    @Column(name = "question", nullable = false)
    private String question;

    @ManyToOne
    @JoinColumn(name = "tests_id", nullable = false, referencedColumnName = "id")
    private Tests test;

    @ManyToOne
    @JoinColumn(name = "question_type_id", nullable = false, referencedColumnName = "id")
    private QuestionType questionType;

    // TODO: 06.02.2023 @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "question", orphanRemoval = true)
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "question")
    private Set<Answer> answerSet;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "question")
    private Set<ImageData> imageDataSet;

    public Questions(Long id) {
        super(id);
    }

    public Questions() {
    }

    public Questions(Long id, String question, Tests test, QuestionType questionType) {
        super(id);
        this.question = question;
        this.test = test;
        this.questionType = questionType;
    }
}
