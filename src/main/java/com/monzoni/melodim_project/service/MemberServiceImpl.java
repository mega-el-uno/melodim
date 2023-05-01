package com.monzoni.melodim_project.service;

import com.monzoni.melodim_project.dto.response.member.MemberResponse;
import com.monzoni.melodim_project.mapper.MemberMapper;
import com.monzoni.melodim_project.repository.MemberRepository;
import com.monzoni.melodim_project.repository.entity.MemberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository, MemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
    }

    @Override
    public List<MemberResponse> getAllMemberList() {
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        return memberEntityList.stream()
                .map(memberMapper::mapperToMemberResponse)
                .collect(Collectors.toList());
    }
}
