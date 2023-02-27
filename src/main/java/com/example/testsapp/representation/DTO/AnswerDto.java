package com.example.testsapp.representation.DTO;

import com.example.testsapp.data.Entity.Answer;
import com.example.testsapp.data.Entity.Questions;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.testsapp.data.Entity.Answer} entity
 */
@Data
public class AnswerDto implements Serializable {
    private final Long id;
    private final String answer;
    private final Boolean is_correct;
    private final Long questions_id;

    //private final QuestionsDto questionsDto;


    public Answer toEntity()
    {
        return new Answer(
                this.id,
                this.answer,
                this.is_correct,
                new Questions(this.questions_id)
        );
    }

    public static AnswerDto toDto(Answer answer)
    {
        return new AnswerDto(
                answer.getId(),
                answer.getAnswer(),
                answer.getIs_correct(),
                answer.getQuestion().getId()
        );
    }
}