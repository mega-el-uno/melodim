package com.monzoni.melodim_project.controller;

import com.monzoni.melodim_project.model.entity.SongEntity_;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SongOrderCriteria {

    ID("ID", SongEntity_.id.getName()),

    TITLE("TITLE", SongEntity_.id.getName()),

    DESCRIPTION("DESCRIPTION", SongEntity_.description.getName()),

    DURATION("DURATION", SongEntity_.duration.getName()),

    RELEASE_DATE("RELEASE_DATE", SongEntity_.releaseDate.getName()),

    ARTIST("ARTIST", SongEntity_.artist.getName()),

    ALBUM("ALBUM", SongEntity_.album.getName()),

    GENRE("GENRE", SongEntity_.genre.getName());

    private String key;
    private String value;

}
