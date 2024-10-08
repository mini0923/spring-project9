package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Member;
import com.example.demo.repository.BoardRepository;
import com.example.demo.repository.MemberRepository;

@SpringBootTest
public class MemberRepositoryTest2 {

	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	BoardRepository boardRepository;
	
		@Test
		void 회원삭제() {
			// 회원 엔티티로 데이터를 추가할 때 : 모든 데이터 작성
			// 회원 엔티티를 이용할 때 : PK만 작성
			Member member = Member.builder()
																	.id("user2")
																	.build();

			// 해당 회원이 작성한 모든 글을 삭제
			boardRepository.deleteWriter(member);
			
			// 그 후 회원을 삭제
			memberRepository.deleteById("user2");
			
		}
		
		@Test
		void 회원일괄등록() {
			List<Member> list = new ArrayList<>();
			
			for (int i = 0; i <= 30; i++) {
				list.add(new Member("user" + i , "1234", "둘리"));
			}
			memberRepository.saveAll(list);
		}
		
	
	
	
	
}
