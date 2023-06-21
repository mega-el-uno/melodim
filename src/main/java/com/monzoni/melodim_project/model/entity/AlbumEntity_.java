package com.monzoni.melodim_project.model.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;

@StaticMetamodel(AlbumEntity.class)
public class AlbumEntity_ {

    public static volatile SingularAttribute<AlbumEntity, Integer> id;

    public static volatile SingularAttribute<AlbumEntity, String> name;

    public static volatile SingularAttribute<AlbumEntity, String> description;

    public static volatile SingularAttribute<AlbumEntity, LocalDate> releaseDate;

}
