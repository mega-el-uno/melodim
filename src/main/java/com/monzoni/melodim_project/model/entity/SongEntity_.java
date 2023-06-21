package com.monzoni.melodim_project.model.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;

@StaticMetamodel(SongEntity.class)
public class SongEntity_ {

    public static volatile SingularAttribute<SongEntity, Integer> id;

    public static volatile SingularAttribute<SongEntity, String> title;

    public static volatile SingularAttribute<SongEntity, String> description;

    public static volatile SingularAttribute<SongEntity, String> duration;

    public static volatile SingularAttribute<SongEntity, LocalDate> releaseDate;

    public static volatile SingularAttribute<SongEntity, ArtistEntity> artist;

    public static volatile SingularAttribute<SongEntity, AlbumEntity> album;

    public static volatile SingularAttribute<SongEntity, GenreEntity> genre;

}
