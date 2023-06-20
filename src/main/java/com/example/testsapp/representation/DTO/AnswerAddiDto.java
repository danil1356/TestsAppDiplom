package com.example.testsapp.representation.DTO;

import com.example.testsapp.data.Entity.AnswerAddi;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A DTO for the {@link com.example.testsapp.data.Entity.AnswerAddi} entity
 */
@Data
public class AnswerAddiDto implements Serializable {
    private final Long id;
    private final String category;

    private final String question_id;

    private final Set<AnswerDto> answerSet;


    public AnswerAddi toEntity(){
        return new AnswerAddi(
                this.id,
                this.category,
                this.question_id
        );
    }

    public static AnswerAddiDto toDto(AnswerAddi answerAddi){
            return new AnswerAddiDto(
                    answerAddi.getId(),
                    answerAddi.getCategory(),
                    answerAddi.getQuestionId(),
                    answerAddi.getAnswerSet() == null? null : answerAddi.getAnswerSet().stream().map(AnswerDto::toDto).collect(Collectors.toSet())
            );
    }

}