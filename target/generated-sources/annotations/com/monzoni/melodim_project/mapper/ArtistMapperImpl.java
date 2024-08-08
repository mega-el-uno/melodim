package com.monzoni.melodim_project.mapper;

import com.monzoni.melodim_project.dto.request.artist.CreateArtistRequest;
import com.monzoni.melodim_project.dto.request.artist.UpdateArtistRequest;
import com.monzoni.melodim_project.dto.response.artist.ArtistResponse;
import com.monzoni.melodim_project.dto.response.artist.GetAllArtistListResponse;
import com.monzoni.melodim_project.model.entity.ArtistEntity;
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
public class ArtistMapperImpl implements ArtistMapper {

    @Override
    public ArtistResponse mapperToArtistResponse(ArtistEntity source) {
        if ( source == null ) {
            return null;
        }

        ArtistResponse artistResponse = new ArtistResponse();

        artistResponse.setId( source.getId() );
        artistResponse.setName( source.getName() );
        artistResponse.setType( source.getType() );
        artistResponse.setCreationDate( source.getCreationDate() );

        return artistResponse;
    }

    @Override
    public GetAllArtistListResponse toGetAllArtistListResponse(String code, String message, List<ArtistResponse> artistResponseList) {
        if ( code == null && message == null && artistResponseList == null ) {
            return null;
        }

        GetAllArtistListResponse getAllArtistListResponse = new GetAllArtistListResponse();

        getAllArtistListResponse.setCode( code );
        getAllArtistListResponse.setMessage( message );
        List<ArtistResponse> list = artistResponseList;
        if ( list != null ) {
            getAllArtistListResponse.setArtistResponseList( new ArrayList<ArtistResponse>( list ) );
        }

        return getAllArtistListResponse;
    }

    @Override
    public ArtistEntity mapperToArtistEntity(CreateArtistRequest source) {
        if ( source == null ) {
            return null;
        }

        ArtistEntity artistEntity = new ArtistEntity();

        artistEntity.setName( source.getName() );
        artistEntity.setType( source.getType() );
        artistEntity.setCreationDate( source.getCreationDate() );

        return artistEntity;
    }

    @Override
    public void mapperToArtistEntity(UpdateArtistRequest updateArtistRequest, ArtistEntity artistEntity) {
        if ( updateArtistRequest == null ) {
            return;
        }

        artistEntity.setId( updateArtistRequest.getId() );
        artistEntity.setName( updateArtistRequest.getName() );
        artistEntity.setType( updateArtistRequest.getType() );
    }
}
