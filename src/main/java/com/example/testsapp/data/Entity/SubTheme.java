package com.example.testsapp.data.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "subthemes")
@Getter
@Setter
@ToString
public class SubTheme extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "theme_id", nullable = false, referencedColumnName = "id")
    private Themes theme;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "subTheme")
    private Set<Tests> testsSet;

    public SubTheme(Long id) {
        super(id);
    }

    public SubTheme() {
    }

    public SubTheme(Long id, String name, Themes theme) {
        super(id);
        this.name = name;
        this.theme = theme;
    }
}
