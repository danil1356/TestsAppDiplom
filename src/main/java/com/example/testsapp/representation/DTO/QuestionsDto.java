package com.example.testsapp.representation.DTO;

import com.example.testsapp.data.Entity.QuestionType;
import com.example.testsapp.data.Entity.Questions;
import com.example.testsapp.data.Entity.Tests;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A DTO for the {@link com.example.testsapp.data.Entity.Questions} entity
 */
@Data
public class QuestionsDto implements Serializable {
    private final Long id;
    private final String question;

    private final Long tests_id;
    //private final TestsDto test;

    private final Long question_type_id;
    //private final QuestionTypeDto questionType;
    private final Set<AnswerDto> answerSet;
    private final Set<ImageDataDto> imageDataSet;


    public Questions toEntity()
    {
        return new Questions(
                this.id,
                this.question,
                new Tests(this.tests_id),
                new QuestionType(this.question_type_id)
        );
    }

    public static QuestionsDto toDto(Questions questions)
    {
        return new QuestionsDto(
                questions.getId(),
                questions.getQuestion(),
                questions.getTest().getId(),
                questions.getQuestionType().getId(),
                questions.getAnswerSet().stream().map(AnswerDto::toDto).collect(Collectors.toSet()),
                questions.getImageDataSet().stream().map(ImageDataDto::toDto).collect(Collectors.toSet())
        );
    }
}