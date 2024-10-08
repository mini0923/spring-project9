package com.example.demo;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;
import com.example.demo.entity.Member;
import com.example.demo.repository.BoardRepository;

@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired
	BoardRepository repository;

		@Test
		void 게시물등록() {
			Member member1 =  Member.builder().id("user1").build();
			Member member2 =  Member.builder().id("user2").build();
			
			
			Board board1 =  Board.builder()
																			.title("안녕하세요")
																			.content("안녕하세요")
																			.writer(member1)
																			.build(); 
			
			Board board2 =  Board.builder()
																			.title("안녕하세요")
																			.content("안녕하세요")
																			.writer(member2)
																			.build(); 
			
			repository.save(board1);
			repository.save(board2);

			
		}
		
		@Test
		void 게시물조회() {
			
			Optional<Board> optional = repository.findById(1);
			
			Board board = optional.get();
			
			System.out.println(board);
						
			// SQL 쿼리에서 board 테이블과 member 테이블이 join 처리되어
			// 게시물 정보에 작성자(회원) 정보가 포함된다.
			
		}
	
		
		
}
