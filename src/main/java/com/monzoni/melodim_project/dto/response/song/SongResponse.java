package com.monzoni.melodim_project.dto.response.song;

import com.monzoni.melodim_project.dto.response.album.AlbumResponse;
import com.monzoni.melodim_project.dto.response.artist.ArtistResponse;
import com.monzoni.melodim_project.dto.response.genre.GenreResponse;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SongResponse {

    private Integer id;

    private String title;

    private String description;

    private String duration;

    private LocalDate releaseDate;

    private ArtistResponse artist;

    private AlbumResponse album;

    private GenreResponse genre;

}
