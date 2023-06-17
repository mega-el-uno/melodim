package com.monzoni.melodim_project.service;

import com.monzoni.melodim_project.dto.request.album.CreateAlbumRequest;
import com.monzoni.melodim_project.dto.request.album.DeleteAlbumRequest;
import com.monzoni.melodim_project.dto.request.album.UpdateAlbumRequest;
import com.monzoni.melodim_project.dto.response.album.AlbumResponse;
import com.monzoni.melodim_project.exception.ProcessErrorException;
import com.monzoni.melodim_project.mapper.AlbumMapper;
import com.monzoni.melodim_project.repository.AlbumRepository;
import com.monzoni.melodim_project.model.entity.AlbumEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final AlbumMapper albumMapper;

    public AlbumServiceImpl(AlbumRepository albumRepository, AlbumMapper albumMapper) {
        this.albumRepository = albumRepository;
        this.albumMapper = albumMapper;
    }

    @Override
    public List<AlbumResponse> getAllAlbumList() {
        List<AlbumEntity> albumEntityList = albumRepository.findAll();
        return albumEntityList.stream()
                .map(albumMapper::mapperToAlbumResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AlbumResponse saveNewAlbum(CreateAlbumRequest createAlbumRequest) {
        AlbumEntity albumEntity = albumMapper.mapperToAlbumEntity(createAlbumRequest);
        return albumMapper.mapperToAlbumResponse(albumRepository.save(albumEntity));
    }

    @Override
    public AlbumResponse UpdateAlbum(UpdateAlbumRequest updateAlbumRequest) {
        Optional<AlbumEntity> albumEntity = albumRepository.findById(updateAlbumRequest.getId());
        if (albumEntity.isPresent()) {
            AlbumEntity preEntity = albumEntity.get();
            albumMapper.mapperToAlbumEntity(updateAlbumRequest, preEntity);
            AlbumEntity postEntity = albumRepository.save(preEntity);

            return albumMapper.mapperToAlbumResponse(postEntity);
        } else {
            throw new ProcessErrorException("The album with ID: " + updateAlbumRequest.getId() + " does not exist");
        }

    }

    @Override
    public AlbumResponse DeleteAlbum(DeleteAlbumRequest deleteAlbumRequest) {
        Optional<AlbumEntity> albumEntity = albumRepository.findById(deleteAlbumRequest.getId());
        albumRepository.deleteById(deleteAlbumRequest.getId());
        return albumMapper.mapperToAlbumResponse(albumEntity.get());
    }

    @Override
    public Boolean existAlbumById(Integer id) {
        Optional<AlbumEntity> albumEntity = albumRepository.findById(id);
        return albumEntity.isPresent();
    }
}
