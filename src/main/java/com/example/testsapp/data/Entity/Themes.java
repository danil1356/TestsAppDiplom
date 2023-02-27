package com.example.testsapp.data.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "themes")
@Getter
@Setter
@ToString
public class Themes extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "theme")
    private Set<SubTheme> subThemeSet;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "theme")
    private Set<Tests> testsSet;

    public Themes(Long id) {
        super(id);
    }

    public Themes() {
    }

    public Themes(Long id, String name) {
        super(id);
        this.name = name;
    }
}
