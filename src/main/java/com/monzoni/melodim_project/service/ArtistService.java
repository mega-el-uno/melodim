package com.monzoni.melodim_project.service;

import com.monzoni.melodim_project.dto.request.CreateArtistRequest;
import com.monzoni.melodim_project.dto.request.UpdateArtistRequest;
import com.monzoni.melodim_project.dto.response.ArtistResponse;

import java.util.List;


public interface ArtistService {
    List<ArtistResponse> getAllArtistList();
    ArtistResponse saveNewArtist(CreateArtistRequest createArtistRequest);
    ArtistResponse updateArtist(UpdateArtistRequest updateArtistRequest);
}
