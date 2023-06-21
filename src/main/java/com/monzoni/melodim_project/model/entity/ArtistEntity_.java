package com.monzoni.melodim_project.model.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;

@StaticMetamodel(ArtistEntity.class)
public class ArtistEntity_ {

    public static volatile SingularAttribute<ArtistEntity, Integer> id;

    public static volatile SingularAttribute<ArtistEntity, String> name;

    public static volatile SingularAttribute<ArtistEntity, String> type;

    public static volatile SingularAttribute<ArtistEntity, LocalDate> creationDate;

}
