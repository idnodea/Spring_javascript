package com.sky.serivice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sky.model.Member;
import com.sky.repository.MemberMapper;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;

    public Member getMemberById(Long id) {

        return memberMapper.selectMemberById(id);
    }

    public List<Member> getAllMember() {

        return memberMapper.selectAllMember();
    }

    @Transactional
    public void insertMember(Member member) {

    	memberMapper.insertMember(member);
    }
}
