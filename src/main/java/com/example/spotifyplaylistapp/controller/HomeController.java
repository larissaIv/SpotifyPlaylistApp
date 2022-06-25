package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.model.DTO.SongDTO;
import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.service.SongService;
import com.example.spotifyplaylistapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {

    private final SongService songService;
    private final UserService userService;

    @Autowired
    public HomeController(SongService songService, UserService userService) {
        this.songService = songService;
        this.userService = userService;
    }

    @ModelAttribute("songDTO")
    public SongDTO initSongDTO() {
        return new SongDTO();
    }

    @GetMapping("/")
    public String loggedOutIndex() {
        if (this.userService.isLoggedIn()) {
            return "redirect:/home";
        }
        return "index";
    }

    @GetMapping("/home")
    public String loggedInIndex(Model model) {

        if (!this.userService.isLoggedIn()) {
            return "redirect:/";
        }

//        long loggedUserId = this.userService.getLoggedUserId();

        List<Song> allSongs = this.songService.getAllSongs();
//        List<SongDTO> fromPlaylist = this.songService.getSongsFromPlaylist();

        model.addAttribute("allSongs", allSongs);
//        model.addAttribute("fromPlaylist", fromPlaylist);


        return "home";
    }

    @GetMapping("/songs/add")
    public String addSong() {
        if (!this.userService.isLoggedIn()) {
            return "redirect:/home";
        }
        return "song-add";
    }

    @PostMapping("/songs/add")
    public String songs(@Valid SongDTO songDTO,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {

        if (!this.userService.isLoggedIn()) {
            return "redirect:/";
        }


        if (bindingResult.hasErrors() || !this.songService.createPlaylist(songDTO)) {
            redirectAttributes.addFlashAttribute("songDTO", songDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.songDTO", bindingResult);

            return "redirect:/songs/add";
        }

        return "redirect:/home";
    }
}