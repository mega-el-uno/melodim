package com.monzoni.melodim_project.service;

import com.monzoni.melodim_project.dto.request.album.CreateAlbumRequest;
import com.monzoni.melodim_project.dto.response.album.AlbumResponse;
import com.monzoni.melodim_project.mapper.AlbumMapper;
import com.monzoni.melodim_project.repository.AlbumRepository;
import com.monzoni.melodim_project.repository.entity.AlbumEntity;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
