package com.cos.myjpa.web.dto.storage;

import com.cos.myjpa.domain.storage.Storage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StorageSaveDto {
	private String title;
	
	public Storage toEntity() {
		Storage storage = new Storage().builder()
				.title(title)
				.build();
		
		return storage;
	}
}
