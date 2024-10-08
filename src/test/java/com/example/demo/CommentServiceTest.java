package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.CommentDTO;
import com.example.demo.service.CommentService;

@SpringBootTest
public class CommentServiceTest {

		@Autowired
		CommentService service;
			
		@Test
		public void 게시물별댓글조회() {
			
				List<CommentDTO> list = service.getListByBoardNo(1);
				
				for(CommentDTO dto : list) {
					System.out.println(dto);
				}
			
		}
	
	
		@Test
		public void 댓글삭제() {
			
			boolean result = service.remove(1);
			
			System.out.println(result);
		}
		
}
