package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.DTO.SongDTO;
import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.repository.SongRepository;
import com.example.spotifyplaylistapp.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SongService {

    private final SongRepository songRepository;
    private final LoggedUser loggedUser;

    public SongService(SongRepository songRepository, LoggedUser loggedUser) {
        this.songRepository = songRepository;
        this.loggedUser = loggedUser;
    }

    public List<Song> getAllSongs() {
        return this.songRepository.findAll();
    }

//    public List<SongDTO> getSongsFromPlaylist() {
//        return this.songRepository.findById(loggedUser.getId())
//                .stream()
//                .map(SongDTO::new).collect(Collectors.toList());
//    }

    public boolean createPlaylist(SongDTO songDTO) {
        Song song = new Song();
        song.setPerformer(songDTO.getPerformer());
        song.setTitle(songDTO.getTitle());
        song.setDuration(songDTO.getDuration());
        song.setReleaseDate(songDTO.getReleaseDate());
        song.setStyle(songDTO.getStyle());

        this.songRepository.save(song);

        return true;

    }
}
