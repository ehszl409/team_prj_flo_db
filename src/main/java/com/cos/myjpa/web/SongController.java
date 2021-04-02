package com.cos.myjpa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.myjpa.domain.song.CategoryType;
import com.cos.myjpa.domain.song.Song;
import com.cos.myjpa.service.SongService;
import com.cos.myjpa.web.dto.CommonRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class SongController {
	
	@Autowired
	ResourceLoader resourceLoader;
	
	private final SongService songService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@PostMapping("/down")
	public CommonRespDto<?> down(@RequestBody Song song) {
		song.setId(null);
		return new CommonRespDto<>(1, "성공", songService.노래저장하기(song));
	}
	
	
	@GetMapping("/song")  //아주 간단히 테스트할 용도
	public CommonRespDto<?> findAll(){

		return new CommonRespDto<>(1,"성공",songService.노래전체찾기());
	}
	
	
	@GetMapping("/song/category")
	public CommonRespDto<?> findCategory(String category){
		
		System.out.println("카테고리" + category);
		
		List<Song> categoryList = songService.카테고리리스트(category);	
		return new CommonRespDto<>(1, "성공", categoryList);
	}
	
	@GetMapping("/song/search")
	public CommonRespDto<?> findByKeyword(String keyword){
		
		System.out.println("카테고리" + keyword);	
		List<Song> searchSongList = songService.검색리스트(keyword);
	
		return new CommonRespDto<>(1, "성공", searchSongList);
	}
	
	
	
//	@GetMapping("/??????????????????")
//	public CommonRespDto<?> findByCategory(){
//		
//		return new CommonRespDto<>(0, null, null);
//	}
	

//	@GetMapping("/{fileName}")
//	public ResponseEntity<Resource> resouceFileDownload(@PathVariable String fileName) {
//		
//		//for문으로 다 돌려서 list에 받고 전달..
//		try {
//		Resource resource  = resourceLoader.getResource("classpath:static/"+ fileName);	
//		File file = resource.getFile();	//파일이 없는 경우 fileNotFoundException error가 난다.
//		
//		return ResponseEntity.ok()
//				.header(HttpHeaders.CONTENT_DISPOSITION,file.getName())	//다운 받아지는 파일 명 설정
//				.header(HttpHeaders.CONTENT_LENGTH, String.valueOf(file.length()))	//파일 사이즈 설정
//				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM.toString())	//바이너리 데이터로 받아오기 설정
//				.body(resource);	//파일 넘기기
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			return ResponseEntity.badRequest()
//					.body(null);
//		} catch (Exception e ) {
//			e.printStackTrace();
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//		} 
//	}
	
}
