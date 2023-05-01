package com.monzoni.melodim_project.dto.response.member;

import com.monzoni.melodim_project.dto.response.artist.ArtistResponse;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MemberResponse {
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private ArtistResponse artist;
}
