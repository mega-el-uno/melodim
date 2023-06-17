package com.monzoni.melodim_project.service;

import com.monzoni.melodim_project.dto.request.artist.CreateArtistRequest;
import com.monzoni.melodim_project.dto.request.artist.DeleteArtistRequest;
import com.monzoni.melodim_project.dto.request.artist.UpdateArtistRequest;
import com.monzoni.melodim_project.dto.response.artist.ArtistResponse;
import com.monzoni.melodim_project.exception.ProcessErrorException;
import com.monzoni.melodim_project.mapper.ArtistMapper;
import com.monzoni.melodim_project.model.entity.ArtistEntity;
import com.monzoni.melodim_project.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;
    private final ArtistMapper artistMapper;

    @Autowired
    public ArtistServiceImpl(ArtistRepository artistRepository, ArtistMapper artistMapper) {
        this.artistRepository = artistRepository;
        this.artistMapper = artistMapper;
    }

    @Override
    public List<ArtistResponse> getAllArtistList() {
        List<ArtistEntity> artistEntityList = artistRepository.findAll();
        return artistEntityList.stream()
                .map(artistMapper::mapperToArtistResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ArtistResponse saveNewArtist(CreateArtistRequest createArtistRequest) {
        ArtistEntity artistEntity = artistMapper.mapperToArtistEntity(createArtistRequest);
        return artistMapper.mapperToArtistResponse(artistRepository.save(artistEntity));
    }

    @Override
    public ArtistResponse updateArtist(UpdateArtistRequest updateArtistRequest) {
        Optional<ArtistEntity> artistEntity = artistRepository.findById(updateArtistRequest.getId());
        if (artistEntity.isPresent()) {
            ArtistEntity preEntity = artistEntity.get();
            artistMapper.mapperToArtistEntity(updateArtistRequest, preEntity);
            ArtistEntity postEntity = artistRepository.save(preEntity);

            return artistMapper.mapperToArtistResponse(postEntity);
        } else {
            throw new ProcessErrorException("This Artist with ID: " + updateArtistRequest.getId() + " does not exist");
        }
    }

    @Override
    public ArtistResponse deleteArtist(DeleteArtistRequest deleteArtistRequest) {
        Optional<ArtistEntity> artistEntityDeleted = artistRepository.findById(deleteArtistRequest.getId());
        artistRepository.deleteById(deleteArtistRequest.getId());
        return artistMapper.mapperToArtistResponse(artistEntityDeleted.get());
    }

    @Override
    public boolean isArtistIdExist(Integer id) {
        Optional<ArtistEntity> artistEntity = artistRepository.findById(id);
        return artistEntity.isPresent();
    }
}
