package com.cos.myjpa.web.dto.storageSong;

import com.cos.myjpa.domain.song.Song;
import com.cos.myjpa.domain.storage.Storage;
import com.cos.myjpa.domain.storageSong.StorageSong;

import lombok.Data;

@Data
public class StorageSongSaveReqDto {
	private Storage storage;
	private Song song;
	
	public StorageSong toEntity() {
		StorageSong storageSong = new StorageSong().builder()
				.song(song)
				.storage(storage)
				.build();
		return storageSong;
		
	}
}
