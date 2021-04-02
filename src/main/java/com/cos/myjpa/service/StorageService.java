package com.cos.myjpa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.myjpa.domain.storage.Storage;
import com.cos.myjpa.domain.storage.StorageRepository;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StorageService {

	private final StorageRepository storageRepo;
	
	
	@Transactional(readOnly = true)
	public List<Storage> 전체찾기(){
		List<Storage> storagesEntity = storageRepo.findAll();
		return storagesEntity;
	}
	
	@Transactional
	public void 저장하기(Storage storage) {
		System.out.println("storage 데이터 : " + storage);
		Storage storageEntity = storageRepo.save(storage);
		System.out.println("storageEntity 데이터 : " + storageEntity);
		
		
	}
	
	@Transactional
	public void 한건삭제하기(int id) {
		storageRepo.deleteById(id);
	}
}
