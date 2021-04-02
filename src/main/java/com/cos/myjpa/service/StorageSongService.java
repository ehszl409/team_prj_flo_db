package com.cos.myjpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContexts;
import javax.persistence.Query;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cos.myjpa.domain.song.Song;
import com.cos.myjpa.domain.storage.Storage;
import com.cos.myjpa.domain.storageSong.StorageSong;
import com.cos.myjpa.domain.storageSong.StorageSongRepository;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StorageSongService {

	private final StorageSongRepository storageSongRepo;
	
	@Transactional
	public void 노래담기(StorageSong storageSong) {
		storageSongRepo.save(storageSong);
	}
	
	
	public List<StorageSong> 노래찾기(int id){
		List<StorageSong> storageSongsEntity = storageSongRepo.findAllSong(id);
		return storageSongsEntity;
	}

}
