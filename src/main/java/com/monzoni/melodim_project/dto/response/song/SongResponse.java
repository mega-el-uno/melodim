package com.monzoni.melodim_project.dto.response.song;

import com.monzoni.melodim_project.model.entity.AlbumEntity;
import com.monzoni.melodim_project.model.entity.ArtistEntity;
import com.monzoni.melodim_project.model.entity.GenreEntity;
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

    private ArtistEntity artist;

    private AlbumEntity album;

    private GenreEntity genre;

}
