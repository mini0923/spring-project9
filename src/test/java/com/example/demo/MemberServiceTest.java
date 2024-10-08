package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.demo.dto.MemberDTO;
import com.example.demo.service.MemberService;

@SpringBootTest
public class MemberServiceTest {

		@Autowired
		MemberService service;
	
		@Test
		public void 빈이주입되었는지확인() {
				System.out.println("service : " + service);
		}
		
		@Test
		void 회원목록조회() {
			Page<MemberDTO> page = service.getList(0);
			
			List<MemberDTO> list = page.getContent();
			
			for (MemberDTO dto : list) {
				System.out.println(dto);
			}
		}
		
		@Test
		void 회원등록() {
//			MemberDTO dto = MemberDTO.builder()
//																				.id("user3")
//																				.password("1234")
//																				.name("또치")
//																				.build();
//			service.register(dto);
			
			MemberDTO dto2 = MemberDTO.builder()
																				.id("user31")	
																				.password("1234")
																				.name("또치")
																				.build();
			boolean isSuccess = service.register(dto2);
			
			System.out.println("처리 결과 : " + isSuccess);
			
		}
		
		@Test
		void 단건조회() {
			
			MemberDTO dto = service.read("user1");
			
			System.out.println(dto);
			
		}
	
}
