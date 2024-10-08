package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CommentDTO;
import com.example.demo.service.CommentService;

@Controller
@RequestMapping("/comment")
@RestController
public class CommentController {
	
		@Autowired
		CommentService service;
		
		// 게시물에 달린 댓글목록을 반환하는 메소드
		@GetMapping("/list")
		public List<CommentDTO> list(@RequestParam(name = "boardNo") int boardNo) {
			
			List<CommentDTO> list =  service.getListByBoardNo(boardNo);
			
			return list;
		}
		
		
		@PostMapping("/register")
		public int register(CommentDTO dto) {
			
				// 스프링 시큐리티를 처리하기 전까지는 임시 아이디 사용
				dto.setWriter("user1");
			
				// 테이블에 댓글 저장
				int newNo = service.register(dto);
				
				return newNo;
		}
		

		@DeleteMapping("/remove")
		public boolean remove(@RequestParam(name = "commentNo") int commentNo) {
			
				// 댓글 삭제 
				boolean result =  service.remove(commentNo);
				
				// 처리 반환
				return result;
				
		}
		
		
		
}
