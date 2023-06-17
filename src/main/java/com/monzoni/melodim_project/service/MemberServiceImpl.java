package com.monzoni.melodim_project.service;

import com.monzoni.melodim_project.dto.request.member.CreateMemberRequest;
import com.monzoni.melodim_project.dto.request.member.DeleteMemberRequest;
import com.monzoni.melodim_project.dto.request.member.UpdateMemberRequest;
import com.monzoni.melodim_project.dto.response.member.MemberResponse;
import com.monzoni.melodim_project.exception.ProcessErrorException;
import com.monzoni.melodim_project.mapper.MemberMapper;
import com.monzoni.melodim_project.model.entity.ArtistEntity;
import com.monzoni.melodim_project.model.entity.MemberEntity;
import com.monzoni.melodim_project.repository.ArtistRepository;
import com.monzoni.melodim_project.repository.MemberRepository;
import com.monzoni.melodim_project.util.function.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService {
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
    public MemberResponse updateMember(UpdateMemberRequest updateMemberRequest) {
        Optional<MemberEntity> memberEntity = memberRepository.findById(updateMemberRequest.getId());
        if (memberEntity.isPresent()) {
            MemberEntity preEntity = memberEntity.get();
            memberMapper.mapperToMemberEntity(updateMemberRequest, preEntity);
            if (!Utils.isNull(updateMemberRequest.getArtistId())) {
                ArtistEntity artist = artistRepository.findById(updateMemberRequest.getArtistId()).get();
                preEntity.setArtist(artist);
            }
            MemberEntity postEntity = memberRepository.save(preEntity);
            return memberMapper.mapperToMemberResponse(postEntity);
        } else {
            throw new ProcessErrorException("The member with ID: " + updateMemberRequest.getId() + " does not exist");
        }
    }

    @Override
    public MemberResponse deleteMember(DeleteMemberRequest deleteMemberRequest) {
        MemberEntity memberEntity = memberRepository.findById(deleteMemberRequest.getId()).get();
        memberRepository.deleteById(deleteMemberRequest.getId());
        return memberMapper.mapperToMemberResponse(memberEntity);
    }

    @Override
    public Boolean existAlbumById(Integer id) {
        Optional<MemberEntity> memberEntity = memberRepository.findById(id);
        return memberEntity.isPresent();
    }

    @Override
    public MemberResponse getMemberById(Integer id) {
        Optional<MemberEntity> memberEntity = memberRepository.findById(id);
        if (memberEntity.isEmpty()){
            throw new ProcessErrorException("The member eith id: " + id + " does not exist");
        }

        return memberMapper.mapperToMemberResponse(memberEntity.get());
    }

}
