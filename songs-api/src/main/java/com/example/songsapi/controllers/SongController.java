package com.example.songsapi.controllers;

import com.example.songsapi.models.Song;
import com.example.songsapi.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SongController {
    @Autowired
    private SongRepository songRepository;

    @GetMapping("/")
    public Iterable<Song> findAllUsers() {
        return songRepository.findAll();
    }

    @GetMapping("/{songId}")
    public Song findSongById(@PathVariable Long songId) {
        return songRepository.findOne(songId);
    }

    @DeleteMapping("/{songId}")
    public HttpStatus deleteById(@PathVariable Long songId) {
        songRepository.delete(songId);
        return HttpStatus.OK;
    }

    @PostMapping("/")
    public Song createNewSong(@RequestBody Song newSong) {
        return songRepository.save(newSong);
    }

    @PatchMapping("/{songId}")
    public Song updateSongById(@PathVariable Long songId, @RequestBody Song songRequest) {
        Song songFromDb = songRepository.findOne(songId);

        songFromDb.setId(songRequest.getId());
        songFromDb.setTitle(songRequest.getTitle());
        songFromDb.setSongLength(songRequest.getSongLength());

        return songRepository.save(songFromDb);
    }
}
