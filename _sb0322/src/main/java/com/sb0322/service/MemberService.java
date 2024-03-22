package com.sb0322.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb0322.dao.MemberDao;
import com.sb0322.dto.MemberDto;



@Service
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	public void insert(MemberDto member) {
		memberDao.insert(member);
	}
	
	public void update(MemberDto member) {
		memberDao.update(member);
	}
	
	public void delete(int memberno) {
		memberDao.delete(memberno);
	}
//	public void delete(String id) {
//		memberDao.delete(id);
//	}
	public List<MemberDto> selectAll() {
		return memberDao.selectAll();
	}
	public MemberDto findByMemberno(int memberno) {
		return memberDao.selectByMemberno(memberno);
	}
	
	public void memoUpdate(int memberno, String memo) {
        memberDao.memoUpdate(memberno, memo);
    }

    public void memoDelete(int memberno) {
        memberDao.memoDelete(memberno);
    }

    // memberno를 이용해 특정 회원의 메모를 조회합니다.
    public String findMemoByMemberno(int memberno) {
        return memberDao.findMemoByMemberno(memberno);
    }
}
	
//	public void memoUpdate(MemberDto member) {
//		memberDao.memoUpdate(member);
//	}
//	public void memoDelete(MemberDto member) {
//		memberDao.memoDelete(member);
//	}
	
//	public MemberDto findById(String id) {
//		return memberDao.selectById(id);
//	}

