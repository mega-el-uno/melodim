package com.monzoni.melodim_project.service;

import com.monzoni.melodim_project.dto.request.CreateArtistRequest;
import com.monzoni.melodim_project.dto.response.ArtistResponse;
import com.monzoni.melodim_project.dto.response.CreateArtistResponse;

import java.util.List;


public interface ArtistService {
    List<ArtistResponse> getAllArtistList();
    ArtistResponse saveNewArtist(CreateArtistRequest createArtistRequest);
}
