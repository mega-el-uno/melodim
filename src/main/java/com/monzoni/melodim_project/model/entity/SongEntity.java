package com.monzoni.melodim_project.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "song_")
public class SongEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_", nullable = false)
    private Integer id;

    @Column(name = "title_")
    private String title;

    @Column(name = "description_")
    private String description;

    @Column(name = "duration_")
    private String duration;

    @Column(name = "release_date_")
    private LocalDate releaseDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = ArtistEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "artist_id_")
    private ArtistEntity artist;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = AlbumEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "album_id_")
    private AlbumEntity album;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = GenreEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id_")
    private GenreEntity genre;

}
