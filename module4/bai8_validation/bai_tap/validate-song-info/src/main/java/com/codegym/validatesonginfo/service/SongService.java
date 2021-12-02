package com.codegym.validatesonginfo.service;

import com.codegym.validatesonginfo.model.Song;

public interface SongService {
    Iterable<Song> findAll();

    Song findById(Integer id);

    void save(Song song);
}
