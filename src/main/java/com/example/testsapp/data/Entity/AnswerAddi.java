package com.example.testsapp.data.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "answer_addi")
@Getter
@Setter
@ToString
public class AnswerAddi extends BaseEntity {

    @Column(name = "category")
    private String category;

    @Column(name = "question_id")
    private String questionId;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "answerAddi")
    private Set<Answer> answerSet;

    public AnswerAddi(){
    }

    public AnswerAddi(Long id){
        super(id);
    }

    public AnswerAddi (Long id, String category, String questionId){
        super(id);
        this.category = category;
        this.questionId = questionId;
    }
}
