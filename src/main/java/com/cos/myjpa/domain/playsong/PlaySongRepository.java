package com.cos.myjpa.domain.playsong;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cos.myjpa.domain.song.Song;

public interface PlaySongRepository extends JpaRepository<PlaySong, Integer>{
	
	@Query(value ="select * FROM playsong where songId=:songId", nativeQuery = true)
	PlaySong mCheckContain(int songId);
}
