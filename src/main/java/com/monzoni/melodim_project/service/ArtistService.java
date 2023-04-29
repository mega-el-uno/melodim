package com.monzoni.melodim_project.service;

import com.monzoni.melodim_project.dto.response.ArtistResponse;

import java.util.List;


public interface ArtistService {
    List<ArtistResponse> getAllArtistList();
}
