package com.example.testsapp.representation.DTO;

import com.example.testsapp.data.Entity.QuestionType;
import com.example.testsapp.data.Entity.Questions;
import com.example.testsapp.data.Entity.Users;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A DTO for the {@link com.example.testsapp.data.Entity.QuestionType} entity
 */
@Data
public class QuestionTypeDto implements Serializable {
    private final Long id;
    private final String type;
    private final Set<QuestionsDto> questionsSet;

    public QuestionType toEntity()
    {
        return new QuestionType(
                this.id,
                this.type

        );
    }

    public static QuestionTypeDto toDto(QuestionType questionType)
    {
        return new QuestionTypeDto(
                questionType.getId(),
                questionType.getType(),
                questionType.getQuestionsSet().stream().map(QuestionsDto::toDto).collect(Collectors.toSet())
        );
    }
}