package com.jafa.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jafa.AppTest;
import com.jafa.domain.MemberVO;
import com.jafa.exception.NotFoundMemberException;

public class AccountRepositoryTest extends AppTest{

	@Autowired
	AccountRepository repository; 
	
	@Test
	public void test() {
		// 보내는 사람 
		MemberVO vo1 = MemberVO
				.builder().pointAccount("1588")
				.memberName("홍길동")
				.build();
		MemberVO memberCheck1 = repository.memberCheck(vo1);
		if(memberCheck1==null) {
			throw new NotFoundMemberException();
		}
		repository.adjustPoint(vo1, -5000);
		
		// 받는 사람 
		MemberVO vo2 = MemberVO
				.builder().pointAccount("7604111")
				.memberName("김철수")
				.build();
		MemberVO memberCheck2 = repository.memberCheck(vo2);
		if(memberCheck2==null) {
			throw new NotFoundMemberException();
		}
		repository.adjustPoint(vo2, +5000);
	}

}
