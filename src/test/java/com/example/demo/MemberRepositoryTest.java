package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Member;
import com.example.demo.repository.BoardRepository;
import com.example.demo.repository.MemberRepository;

@SpringBootTest
public class MemberRepositoryTest {

	@Autowired
	MemberRepository repository;
	
	@Autowired
	BoardRepository repository2;
	
	@Test
	void 회원등록() {
		Member member1 = Member.builder()
																.id("user1")
																.password("1234")
																.name("둘리")
																.build();
		
		Member member2 = Member.builder()
																.id("user2")
																.password("1234")
																.name("또치")
																.build();
		
		repository.save(member1);
		repository.save(member2);
		
	}
	
	@Test
	void 회원목록조회() {
		List<Member> list = repository.findAll();
		
		for (Member m : list) {
			System.out.println(m);
		}
	}
		
		@Test
		void 회원단건조회() {
			Optional<Member> optional = repository.findById("user1");
			
			if(optional.isPresent()) {
				Member member = optional.get();
				System.out.println(member);
			}
		}
		
		@Test
		void 회원수정() {
			Optional<Member> optional = repository.findById("user1");
			
			Member member = optional.get();
			
			member.setName("수정");
			
			repository.save(member);
			
			System.out.println(member);
		}
		
		@Test
		void 회원삭제() {
			
			// 게시물이 작성한 회원은 바로 삭제할 수 없음
			// 회원을 삭제하려면 먼저 회원이 작성한 게시물을 삭제해야함
			
			repository2.deleteAll();
			
			repository.deleteAll();
		}
		
		
	
	
	
	
}
