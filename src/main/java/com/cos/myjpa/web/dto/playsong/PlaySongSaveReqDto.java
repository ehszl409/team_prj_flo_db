package com.cos.myjpa.web.dto.playsong;

import com.cos.myjpa.domain.playsong.PlaySong;
import com.cos.myjpa.domain.song.Song;

import lombok.Data;

@Data
public class PlaySongSaveReqDto {

	private Song song;
	
	public PlaySong toEntity() {
		return PlaySong.builder().song(song).build();
	}
	
}
