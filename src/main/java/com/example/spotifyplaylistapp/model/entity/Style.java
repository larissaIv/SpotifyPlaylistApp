package com.example.spotifyplaylistapp.model.entity;

import com.example.spotifyplaylistapp.model.enums.StyleName;

import javax.persistence.*;

@Entity
@Table(name = "styles")
public class Style {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private StyleName name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Style() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StyleName getName() {
        return name;
    }

    public void setName(StyleName name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
