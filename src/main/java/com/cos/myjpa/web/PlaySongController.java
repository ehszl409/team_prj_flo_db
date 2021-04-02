package com.cos.myjpa.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.myjpa.domain.playsong.PlaySong;
import com.cos.myjpa.domain.song.Song;
import com.cos.myjpa.service.PlaySongService;
import com.cos.myjpa.web.dto.CommonRespDto;
import com.cos.myjpa.web.dto.playsong.PlaySongSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PlaySongController { //내 재생목록

	private final PlaySongService playSongService;
	
	
	@GetMapping("/playSong")
	public CommonRespDto<?> findAll() {

		return new CommonRespDto<>(1, "성공", playSongService.전체찾기());
	}
	
	
	@PostMapping("/playSong")
	public CommonRespDto<?> save(@RequestBody PlaySongSaveReqDto playSongSaveReqDto) {
		//System.out.println("재생목록에 곡 추가"+ song);
		//System.out.println("재생목록에 곡 추가"+ playSongSaveReqDto);
			
		return new CommonRespDto<>(1, "성공", playSongService.노래추가(playSongSaveReqDto.toEntity()));
	}
	
	
	@DeleteMapping("/playSong/{id}")
	public CommonRespDto<?> deleteById(@PathVariable int id){
		
		System.out.println("id:  " + id);
		
		playSongService.노래삭제(id);
		
		return new CommonRespDto<>(1, "성공", "");
	}
	
}
