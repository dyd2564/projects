package com.jafa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jafa.domain.MemberVO;
import com.jafa.domain.TransferDTO;
import com.jafa.exception.InsufficientException;
import com.jafa.exception.NotFoundMemberException;
import com.jafa.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	@Transactional
	public void pointTranfer(TransferDTO dto) {
		int amount = dto.getAmount(); // 보낼 금액 
		
		// 보내는 사람
		MemberVO vo1 = MemberVO.builder()
				.memberName(dto.getFromMemberName())
				.pointAccount(dto.getFromAccount())
				.build();
		MemberVO memberCheck1 = accountRepository.memberCheck(vo1);
		if(memberCheck1==null) throw new NotFoundMemberException();
		if(memberCheck1.getPoint() < dto.getAmount()) throw new InsufficientException();
		accountRepository.adjustPoint(vo1, amount*(-1));
		
		// 받는 사람 
		MemberVO vo2 = MemberVO.builder()
				.memberName(dto.getToMemberName())
				.pointAccount(dto.getToAccount())
				.build();
		MemberVO memberCheck2 = accountRepository.memberCheck(vo2);
		if(memberCheck2==null) throw new NotFoundMemberException();
		accountRepository.adjustPoint(vo2, amount);
	}
}
