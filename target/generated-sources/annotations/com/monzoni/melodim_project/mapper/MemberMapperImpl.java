package com.monzoni.melodim_project.mapper;

import com.monzoni.melodim_project.dto.request.member.CreateMemberRequest;
import com.monzoni.melodim_project.dto.request.member.UpdateMemberRequest;
import com.monzoni.melodim_project.dto.response.artist.ArtistResponse;
import com.monzoni.melodim_project.dto.response.member.GetAllMemberListResponse;
import com.monzoni.melodim_project.dto.response.member.MemberResponse;
import com.monzoni.melodim_project.model.entity.ArtistEntity;
import com.monzoni.melodim_project.model.entity.MemberEntity;
import com.monzoni.melodim_project.util.constant.ResponseConstant.SuccessResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-07T23:41:46-0400",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public MemberResponse mapperToMemberResponse(MemberEntity source) {
        if ( source == null ) {
            return null;
        }

        MemberResponse memberResponse = new MemberResponse();

        memberResponse.setName( source.getName() );
        memberResponse.setLastName( source.getLastName() );
        memberResponse.setBirthDate( source.getBirthDate() );
        memberResponse.setArtist( artistEntityToArtistResponse( source.getArtist() ) );

        return memberResponse;
    }

    @Override
    public MemberEntity mapperToMemberEntity(CreateMemberRequest createMemberRequest) {
        if ( createMemberRequest == null ) {
            return null;
        }

        MemberEntity memberEntity = new MemberEntity();

        memberEntity.setName( createMemberRequest.getName() );
        memberEntity.setLastName( createMemberRequest.getLastName() );
        memberEntity.setBirthDate( createMemberRequest.getBirthDate() );

        return memberEntity;
    }

    @Override
    public void mapperToMemberEntity(UpdateMemberRequest source, MemberEntity target) {
        if ( source == null ) {
            return;
        }

        target.setId( source.getId() );
        target.setName( source.getName() );
        target.setLastName( source.getLastName() );
        target.setBirthDate( source.getBirthDate() );
    }

    @Override
    public GetAllMemberListResponse toGetAllMemberListResponse(String code, String message, List<MemberResponse> memberResponseList) {
        if ( code == null && message == null && memberResponseList == null ) {
            return null;
        }

        GetAllMemberListResponse getAllMemberListResponse = new GetAllMemberListResponse();

        getAllMemberListResponse.setCode( code );
        getAllMemberListResponse.setMessage( message );
        List<MemberResponse> list = memberResponseList;
        if ( list != null ) {
            getAllMemberListResponse.setMemberResponseList( new ArrayList<MemberResponse>( list ) );
        }

        return getAllMemberListResponse;
    }

    protected ArtistResponse artistEntityToArtistResponse(ArtistEntity artistEntity) {
        if ( artistEntity == null ) {
            return null;
        }

        ArtistResponse artistResponse = new ArtistResponse();

        artistResponse.setId( artistEntity.getId() );
        artistResponse.setName( artistEntity.getName() );
        artistResponse.setType( artistEntity.getType() );
        artistResponse.setCreationDate( artistEntity.getCreationDate() );

        return artistResponse;
    }
}
