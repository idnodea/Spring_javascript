package co_1.sp0321pro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co_1.sp0321pro.dao.MemberDao;
import co_1.sp0321pro.dto.MemberDto;

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
	
	public void memoUpdate(MemberDto member) {
		memberDao.memoUpdate(member);
	}
	public void memoDelete(int memberno) {
		memberDao.memoDelete(memberno);
	}
//	public MemberDto findById(String id) {
//		return memberDao.selectById(id);
//	}
}
