package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.BoardDTO;
import com.example.demo.service.BoardService;

@SpringBootTest
public class BoardServiceTest {

	@Autowired
	BoardService service;
	
	@Test
	void 게시물등록() {
		BoardDTO dto = BoardDTO.builder()
																.title("하이")
																.content("하이")
																.writer("user1")
																.build();
		
		int no = service.register(dto);
		
		System.out.println("새로운 게시물 등록  : "  + no);
	}
	
	
	
}
