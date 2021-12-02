package com.codegym.validatesonginfo.repository;

import com.codegym.validatesonginfo.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SongRepository extends JpaRepository<Song,Integer> {
}
