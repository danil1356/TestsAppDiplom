package com.example.testsapp.representation.DTO;

import com.example.testsapp.data.Entity.Answer;
import com.example.testsapp.data.Entity.AnswerAddi;
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
    private final Long answer_addi_id;

    private final String index;

    //private final QuestionsDto questionsDto;


    public Answer toEntity()
    {
        // TODO: 18.04.2023 ВОЗМОЖНО НЕ ВЕРНО
        return new Answer(
                this.id,
                this.answer,
                this.is_correct,
                new Questions(this.questions_id),
                this.answer_addi_id == null? null : new AnswerAddi(this.answer_addi_id),
                this.index
        );
    }

    public static AnswerDto toDto(Answer answer)
    {
        // TODO: 18.04.2023 ВЕРНО
        return new AnswerDto(
                answer.getId(),
                answer.getAnswer(),
                answer.getIs_correct(),
                answer.getQuestion().getId(),
                answer.getAnswerAddi()==null? null : answer.getAnswerAddi().getId(),
                answer.getIndex()
        );

    }
}