package com.cos.myjpa.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.myjpa.domain.storageSong.StorageSong;
import com.cos.myjpa.service.StorageSongService;
import com.cos.myjpa.web.dto.CommonRespDto;
import com.cos.myjpa.web.dto.storageSong.StorageSongSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class StorageSongController {

	private final StorageSongService storageSongService;
	
	@PostMapping("/storageSong")
	public void save(@RequestBody StorageSongSaveReqDto saveReqDto) {
		storageSongService.노래담기(saveReqDto.toEntity());
	}
	
	@GetMapping("/storageSong/{id}")
	public CommonRespDto<?> findAll(@PathVariable int id){
		List<StorageSong> storageSongEntity = storageSongService.노래찾기(id);
		return new CommonRespDto<>(1, "성공", storageSongEntity);
	}
}
