package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;
import com.example.demo.entity.Comment;
import com.example.demo.entity.Member;
import com.example.demo.repository.CommentRepository;

@SpringBootTest
public class CommentRepositoryTest {

	@Autowired
	CommentRepository repository;

		@Test
		public void 등록() {
			Member member = Member.builder().id("user1").build();
	
			Board board = Board.builder().no(1).build();
	
			Comment comment = new Comment(0, board, "댓글입니다", member);
	
			repository.save(comment);
		}
	
		@Test
		public void 조회() {
			List<Comment> list = new ArrayList<>();
	
			for (Comment comment : list) {
				System.out.println(comment);
			}
		}
	
		@Test
		public void 단건조회() {
			Optional<Comment> result = repository.findById(1);
	
			if (result.isPresent()) {
				Comment comment = result.get();
				System.out.println(comment);
			}
		}
	
		@Test
		public void 수정() {
			Optional<Comment> result = repository.findById(1);
	
			Comment comment = result.get();
	
			comment.setContent("수정이요");
	
			repository.save(comment);
	
		}
	
		@Test
		public void 단건삭제() {
			repository.deleteById(1);
		}

		@Test
		public void 게시물별_댓글조회() {
			Board board = Board.builder().no(1).build();
	
			List<Comment> list = repository.findByBoard(board);
			 
			for (Comment comment : list) {
				System.out.println(comment); 
			}
		}
		
		@Test
		public void 게시물별_댓글삭제() {
			Board board = Board.builder().no(1).build();
			
			repository.deleteByBoard(board);
		}

}
