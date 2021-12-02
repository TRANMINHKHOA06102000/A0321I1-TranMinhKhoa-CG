package com.codegym.validatesonginfo.service.impl;

import com.codegym.validatesonginfo.model.Song;
import com.codegym.validatesonginfo.repository.SongRepository;
import com.codegym.validatesonginfo.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongServiceImpl implements SongService {
    @Autowired
    SongRepository songRepository;
    @Override
    public Iterable<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Song findById(Integer id) {
        return songRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }
}
