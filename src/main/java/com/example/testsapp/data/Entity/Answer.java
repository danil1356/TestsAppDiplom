package com.example.testsapp.data.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "answer")
@Getter
@Setter
@ToString
public class Answer extends BaseEntity{

    @Column(name = "answer", nullable = false)
    private String answer;

    @Column(name = "is_correct", nullable = false)
    private Boolean is_correct;

    @ManyToOne
    @JoinColumn(name = "questions_id", nullable = false, referencedColumnName = "id")
    private Questions question;

    public Answer(Long id) {
        super(id);
    }

    public Answer() {
    }

    public Answer(Long id, String answer, Boolean is_correct, Questions question) {
        super(id);
        this.answer = answer;
        this.is_correct = is_correct;
        this.question = question;
    }
}
