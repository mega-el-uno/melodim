package com.monzoni.melodim_project.mapper;

import com.monzoni.melodim_project.dto.request.album.CreateAlbumRequest;
import com.monzoni.melodim_project.dto.request.album.UpdateAlbumRequest;
import com.monzoni.melodim_project.dto.response.album.AlbumResponse;
import com.monzoni.melodim_project.dto.response.album.GetAllAlbumListResponse;
import com.monzoni.melodim_project.model.entity.AlbumEntity;
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
public class AlbumMapperImpl implements AlbumMapper {

    @Override
    public AlbumResponse mapperToAlbumResponse(AlbumEntity source) {
        if ( source == null ) {
            return null;
        }

        AlbumResponse albumResponse = new AlbumResponse();

        albumResponse.setId( source.getId() );
        albumResponse.setName( source.getName() );
        albumResponse.setDescription( source.getDescription() );
        albumResponse.setReleaseDate( source.getReleaseDate() );

        return albumResponse;
    }

    @Override
    public AlbumEntity mapperToAlbumEntity(CreateAlbumRequest source) {
        if ( source == null ) {
            return null;
        }

        AlbumEntity albumEntity = new AlbumEntity();

        albumEntity.setName( source.getName() );
        albumEntity.setDescription( source.getDescription() );
        albumEntity.setReleaseDate( source.getReleaseDate() );

        return albumEntity;
    }

    @Override
    public void mapperToAlbumEntity(UpdateAlbumRequest source, AlbumEntity target) {
        if ( source == null ) {
            return;
        }

        target.setId( source.getId() );
        target.setName( source.getName() );
        target.setDescription( source.getDescription() );
        target.setReleaseDate( source.getReleaseDate() );
    }

    @Override
    public GetAllAlbumListResponse toGetAllAlbumListResponse(String code, String message, List<AlbumResponse> albumResponseList) {
        if ( code == null && message == null && albumResponseList == null ) {
            return null;
        }

        GetAllAlbumListResponse getAllAlbumListResponse = new GetAllAlbumListResponse();

        getAllAlbumListResponse.setCode( code );
        getAllAlbumListResponse.setMessage( message );
        List<AlbumResponse> list = albumResponseList;
        if ( list != null ) {
            getAllAlbumListResponse.setAlbumResponseList( new ArrayList<AlbumResponse>( list ) );
        }

        return getAllAlbumListResponse;
    }
}
