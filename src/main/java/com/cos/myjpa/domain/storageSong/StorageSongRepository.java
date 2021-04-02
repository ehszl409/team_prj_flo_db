package com.cos.myjpa.domain.storageSong;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cos.myjpa.domain.song.Song;

public interface StorageSongRepository extends JpaRepository<StorageSong, Integer> {
	

	@Query(value = "select * from storagesong st inner join song s on st.songId = s.id where st.storageId = :id",
			nativeQuery = true)
	List<StorageSong> findAllSong(int id);
}

