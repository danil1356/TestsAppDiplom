package com.example.testsapp.representation.DTO;

import com.example.testsapp.data.Entity.ImageData;
import com.example.testsapp.data.Entity.Questions;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.testsapp.data.Entity.ImageData} entity
 */
@Data
public class ImageDataDto implements Serializable {
    private final Long id;
    private final String img_src;
    private final Long questions_id;
    //private final QuestionsDto question;

    public ImageData toEntity()
    {
        return new ImageData(
                this.id,
                this.img_src,
                new Questions(this.questions_id)
        );
    }

    public static ImageDataDto toDto(ImageData imageData)
    {
        return new ImageDataDto(
                imageData.getId(),
                imageData.getImg_src(),
                imageData.getQuestion().getId()
        );
    }
}