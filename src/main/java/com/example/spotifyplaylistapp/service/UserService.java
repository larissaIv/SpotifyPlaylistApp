package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.DTO.LoginDTO;
import com.example.spotifyplaylistapp.model.DTO.UserRegistrationDTO;
import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.repository.UserRepository;
import com.example.spotifyplaylistapp.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final LoggedUser userSession;

    public UserService(UserRepository userRepository, LoggedUser userSession) {
        this.userRepository = userRepository;
        this.userSession = userSession;
    }

    public boolean register(UserRegistrationDTO registrationDTO) {
        if (!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())) {
            return false;
        }

        Optional<User> byEmail = this.userRepository.findByEmail(registrationDTO.getEmail());
        if (byEmail.isPresent()) {
            return false;
        }

        Optional<User> byUsername = this.userRepository.findByUsername(registrationDTO.getUsername());
        if (byUsername.isPresent()) {
            return false;
        }

        User user = new User();
        user.setUsername(registrationDTO.getUsername());
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(registrationDTO.getPassword());

        this.userRepository.save(user);

        return true;
    }

    public boolean login(LoginDTO loginDTO) {
        Optional<User> user = this.userRepository.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());

        if (user.isEmpty()) {
            return false;
        }

        this.userSession.login(user.get());
        return true;
    }

    public boolean isLoggedIn() {
        return this.userSession.getId() > 0;
    }


    public void logout() {
        this.userSession.logout();
    }

    public long getLoggedUserId() {
        return this.userSession.getId();
    }
}
