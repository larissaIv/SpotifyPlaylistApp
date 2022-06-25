package com.example.spotifyplaylistapp.model.DTO;

import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.enums.StyleName;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SongDTO {

    @Size(min = 3, max = 20)
    private String performer;

    @Size(min = 2, max = 20)
    private String title;

    @Positive
    private float duration;

    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    private StyleName style;

    public SongDTO() {
    }

    public SongDTO(Song song) {
        this();
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
