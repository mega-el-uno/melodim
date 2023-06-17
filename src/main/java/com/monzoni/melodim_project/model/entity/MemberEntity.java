package com.monzoni.melodim_project.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "member_")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_", nullable = false)
    private Integer id;

    @Column(name = "name_")
    private String name;

    @Column(name = "last_name_")
    private String lastName;

    @Column(name = "birth_date_")
    private LocalDate birthDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = ArtistEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "artist_id_")
    private ArtistEntity artist;
}
