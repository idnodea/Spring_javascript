package com.sky.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sky.model.MemberPro;
import com.sky.repository.MemberMapper;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;

    public MemberPro getMemberProById(Long id) {

        return memberMapper.selectMemberById(id);
    }

    public List<MemberPro> getAllMemberPro() {

        return memberMapper.selectAllMemberPro();
    }

    @Transactional
    public void addMemberPro(MemberPro memberPro) {

        memberMapper.insertMemberPro(memberPro);
    }
}
