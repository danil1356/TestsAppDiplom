package com.example.testsapp.data.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "image_data")
@Getter
@Setter
@ToString
public class ImageData extends BaseEntity{

    @Column(name = "img_src", nullable = false)
    private String img_src;

    @ManyToOne
    @JoinColumn(name = "questions_id", nullable = false, referencedColumnName = "id")
    private Questions question;

    public ImageData(Long id) {
        super(id);
    }

    public ImageData() {
    }

    public ImageData(Long id, String img_src, Questions question) {
        super(id);
        this.img_src = img_src;
        this.question = question;
    }
}
