package com.jafa.repository;

import org.apache.ibatis.annotations.Param;

import com.jafa.domain.MemberVO;

public interface AccountRepository {
	
	MemberVO memberCheck(MemberVO vo);
	
	void adjustPoint(@Param("m") MemberVO vo, @Param("amount") int amount);
}
