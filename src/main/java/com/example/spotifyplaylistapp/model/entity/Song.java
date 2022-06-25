package com.example.spotifyplaylistapp.model.entity;

import com.example.spotifyplaylistapp.model.enums.StyleName;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String performer;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private float duration;

    private LocalDate releaseDate;

    private StyleName style;

    public Song() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public StyleName getStyle() {
        return style;
    }

    public void setStyle(StyleName style) {
        this.style = style;
    }
}
