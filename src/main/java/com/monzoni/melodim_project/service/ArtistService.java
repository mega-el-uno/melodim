package com.monzoni.melodim_project.service;

import com.monzoni.melodim_project.dto.request.artist.CreateArtistRequest;
import com.monzoni.melodim_project.dto.request.artist.DeleteArtistRequest;
import com.monzoni.melodim_project.dto.request.artist.UpdateArtistRequest;
import com.monzoni.melodim_project.dto.response.artist.ArtistResponse;

import java.util.List;


public interface ArtistService {
    List<ArtistResponse> getAllArtistList();

    ArtistResponse saveNewArtist(CreateArtistRequest createArtistRequest);

    ArtistResponse updateArtist(UpdateArtistRequest updateArtistRequest);

    ArtistResponse deleteArtist(DeleteArtistRequest deleteArtistRequest);

    boolean isArtistIdExist(Integer id);

    ArtistResponse getArtistById(Integer id);
}
