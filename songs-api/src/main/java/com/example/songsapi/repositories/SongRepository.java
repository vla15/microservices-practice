package com.example.songsapi.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.songsapi.models.Song;

public interface SongRepository extends CrudRepository<Song, Long> {
}

