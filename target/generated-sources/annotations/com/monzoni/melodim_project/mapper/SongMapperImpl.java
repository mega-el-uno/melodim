package com.monzoni.melodim_project.mapper;

import com.monzoni.melodim_project.dto.request.song.CreateSongRequest;
import com.monzoni.melodim_project.dto.request.song.UpdateSongRequest;
import com.monzoni.melodim_project.dto.response.album.AlbumResponse;
import com.monzoni.melodim_project.dto.response.artist.ArtistResponse;
import com.monzoni.melodim_project.dto.response.genre.GenreResponse;
import com.monzoni.melodim_project.dto.response.song.SongResponse;
import com.monzoni.melodim_project.model.entity.AlbumEntity;
import com.monzoni.melodim_project.model.entity.ArtistEntity;
import com.monzoni.melodim_project.model.entity.GenreEntity;
import com.monzoni.melodim_project.model.entity.SongEntity;
import com.monzoni.melodim_project.util.constant.ResponseConstant.SuccessResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-07T23:41:46-0400",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class SongMapperImpl implements SongMapper {

    @Override
    public SongResponse mapperToSongResponse(SongEntity songEntity) {
        if ( songEntity == null ) {
            return null;
        }

        SongResponse songResponse = new SongResponse();

        songResponse.setId( songEntity.getId() );
        songResponse.setTitle( songEntity.getTitle() );
        songResponse.setDescription( songEntity.getDescription() );
        songResponse.setDuration( songEntity.getDuration() );
        songResponse.setReleaseDate( songEntity.getReleaseDate() );
        songResponse.setArtist( artistEntityToArtistResponse( songEntity.getArtist() ) );
        songResponse.setAlbum( albumEntityToAlbumResponse( songEntity.getAlbum() ) );
        songResponse.setGenre( genreEntityToGenreResponse( songEntity.getGenre() ) );

        return songResponse;
    }

    @Override
    public SongEntity mapperToSongEntity(CreateSongRequest createSongRequest) {
        if ( createSongRequest == null ) {
            return null;
        }

        SongEntity songEntity = new SongEntity();

        songEntity.setTitle( createSongRequest.getTitle() );
        songEntity.setDescription( createSongRequest.getDescription() );
        songEntity.setDuration( createSongRequest.getDuration() );
        songEntity.setReleaseDate( createSongRequest.getReleaseDate() );

        return songEntity;
    }

    @Override
    public void mapperToSongEntity(UpdateSongRequest source, SongEntity target) {
        if ( source == null ) {
            return;
        }

        target.setId( source.getId() );
        target.setTitle( source.getTitle() );
        target.setDescription( source.getDescription() );
        target.setDuration( source.getDuration() );
        target.setReleaseDate( source.getReleaseDate() );
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

    protected AlbumResponse albumEntityToAlbumResponse(AlbumEntity albumEntity) {
        if ( albumEntity == null ) {
            return null;
        }

        AlbumResponse albumResponse = new AlbumResponse();

        albumResponse.setId( albumEntity.getId() );
        albumResponse.setName( albumEntity.getName() );
        albumResponse.setDescription( albumEntity.getDescription() );
        albumResponse.setReleaseDate( albumEntity.getReleaseDate() );

        return albumResponse;
    }

    protected GenreResponse genreEntityToGenreResponse(GenreEntity genreEntity) {
        if ( genreEntity == null ) {
            return null;
        }

        GenreResponse genreResponse = new GenreResponse();

        genreResponse.setId( genreEntity.getId() );
        genreResponse.setName( genreEntity.getName() );

        return genreResponse;
    }
}
