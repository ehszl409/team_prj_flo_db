package com.cos.myjpa.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.myjpa.domain.storage.Storage;
import com.cos.myjpa.service.StorageService;
import com.cos.myjpa.web.dto.CommonRespDto;
import com.cos.myjpa.web.dto.storage.StorageSaveDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class StorageController {

	private final StorageService storageService;
	
	@GetMapping("/storage/test")
		public CommonRespDto<?> storageTest() {
			return new CommonRespDto<>(1, "성공", "테스트 데이터 전달");
		}
	
	@GetMapping("/storage")
	public CommonRespDto<?> storageFindAll(){
		List<Storage> storagesList = storageService.전체찾기();
		System.out.println("데이터 확인 : " + storagesList);
		return new CommonRespDto<>(1, "성공", storagesList);
	}
	
	@PostMapping("/storage")
	public CommonRespDto<?> storageSave(@RequestBody StorageSaveDto storageSaveDto){
		storageService.저장하기(storageSaveDto.toEntity());
		return new CommonRespDto<>(1, "성공", "추가하기 성공");
	}
	
	@DeleteMapping("/storage/{id}")
	public CommonRespDto<?> storageDelete(@PathVariable int id){
		storageService.한건삭제하기(id);
		return new CommonRespDto<>(1, "성공", "삭제하기 성공");
	}
}
