package com.monzoni.melodim_project.service;

import com.monzoni.melodim_project.dto.request.member.CreateMemberRequest;
import com.monzoni.melodim_project.dto.response.member.MemberResponse;
import com.monzoni.melodim_project.mapper.MemberMapper;
import com.monzoni.melodim_project.repository.ArtistRepository;
import com.monzoni.melodim_project.repository.MemberRepository;
import com.monzoni.melodim_project.repository.entity.ArtistEntity;
import com.monzoni.melodim_project.repository.entity.MemberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;
    private final ArtistRepository artistRepository;
    private final MemberMapper memberMapper;
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository, ArtistRepository artistRepository, MemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.artistRepository = artistRepository;
        this.memberMapper = memberMapper;
    }

    @Override
    public List<MemberResponse> getAllMemberList() {
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        return memberEntityList.stream()
                .map(memberMapper::mapperToMemberResponse)
                .collect(Collectors.toList());
    }

    @Override
    public MemberResponse saveNewMember(CreateMemberRequest createMemberRequest) {
        ArtistEntity artistEntity = artistRepository.findById(createMemberRequest.getArtistId()).get();
        MemberEntity memberEntity = memberMapper.mapperToMemberEntity(createMemberRequest);
        memberEntity.setArtist(artistEntity);
        return memberMapper.mapperToMemberResponse(memberRepository.save(memberEntity));
    }

    @Override
    public Boolean existMemberId(Integer id) {
        Optional<MemberEntity> memberEntity = memberRepository.findById(id);
        return memberEntity.isPresent();
    }


}
