package com.monzoni.melodim_project.service;

import com.monzoni.melodim_project.dto.request.song.CreateSongRequest;
import com.monzoni.melodim_project.dto.request.song.GetSongByPageRequest;
import com.monzoni.melodim_project.dto.request.song.UpdateSongRequest;
import com.monzoni.melodim_project.dto.response.PaginationResponse;
import com.monzoni.melodim_project.dto.response.song.SongResponse;
import com.monzoni.melodim_project.exception.ProcessErrorException;
import com.monzoni.melodim_project.mapper.BasePaginationMapper;
import com.monzoni.melodim_project.mapper.SongMapper;
import com.monzoni.melodim_project.model.entity.*;
import com.monzoni.melodim_project.repository.AlbumRepository;
import com.monzoni.melodim_project.repository.ArtistRepository;
import com.monzoni.melodim_project.repository.GenreRepository;
import com.monzoni.melodim_project.repository.SongRepository;
import com.monzoni.melodim_project.util.function.Specifications;
import com.monzoni.melodim_project.util.function.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    private final AlbumRepository albumRepository;

    private final ArtistRepository artistRepository;

    private final GenreRepository genreRepository;

    private final SongMapper songMapper;

    @Override
    public SongResponse saveNewSong(CreateSongRequest request) {
        SongEntity newSongEntity = songMapper.mapperToSongEntity(request);

        AlbumEntity album = albumRepository.findById(request.getAlbumId()).get();
        ArtistEntity artist = artistRepository.findById(request.getArtistId()).get();
        GenreEntity genre = genreRepository.findById(request.getGenreId()).get();

        newSongEntity.setAlbum(album);
        newSongEntity.setArtist(artist);
        newSongEntity.setGenre(genre);

        return songMapper.mapperToSongResponse(songRepository.save(newSongEntity));
    }

    @Override
    public SongResponse updateSong(UpdateSongRequest request) {
        Optional<SongEntity> songEntity = songRepository.findById(request.getId());
        if (songEntity.isPresent()) {
            SongEntity preEntity = songEntity.get();
            songMapper.mapperToSongEntity(request, preEntity);

            if (!Utils.isNull(request.getAlbumId())) {
                AlbumEntity album = albumRepository.findById(request.getAlbumId()).get();
                preEntity.setAlbum(album);
            }
            if (!Utils.isNull(request.getArtistId())) {
                ArtistEntity artist = artistRepository.findById(request.getArtistId()).get();
                preEntity.setArtist(artist);
            }
            if (!Utils.isNull(request.getGenreId())) {
                GenreEntity genre = genreRepository.findById(request.getGenreId()).get();
                preEntity.setGenre(genre);
            }

            SongEntity postEntity = songRepository.save(preEntity);
            return songMapper.mapperToSongResponse(postEntity);
        } else {
            throw new ProcessErrorException("The song with ID: " + request.getId() + " does not exist");
        }
    }

    @Override
    public SongResponse deleteSong(Integer id) {
        SongEntity songEntity = songRepository.findById(id).get();
        songRepository.deleteById(id);
        return songMapper.mapperToSongResponse(songEntity);
    }

    @Override
    public Boolean existSongById(Integer id) {
        return songRepository.findById(id).isPresent();
    }

    @Override
    public SongResponse getSongById(Integer id) {
        Optional<SongEntity> songEntity = songRepository.findById(id);
        if (songEntity.isEmpty()) {
            throw new ProcessErrorException("The song with id: " + id + " does not exist");
        }

        return songMapper.mapperToSongResponse(songEntity.get());
    }

    @Override
    public PaginationResponse<SongResponse> getSongByPage(GetSongByPageRequest request) {
        PaginationResponse<SongResponse> response = new PaginationResponse<>();

        Sort sort = Specifications.buildSorting(request.getOrder(), request.getDirection());
        PageRequest pageRequest = PageRequest.of(request.getPage(), request.getSize(), sort);

        Page<SongEntity> songEntityPage = songRepository.findAll(buildSpecification(request), pageRequest);
        List<SongResponse> songResponseList = songEntityPage.get()
                .map(songMapper::mapperToSongResponse)
                .collect(Collectors.toList());

        response.setItems(songResponseList);
        return BasePaginationMapper.setPageMetadata(response, songEntityPage);
    }

    private Specification<SongEntity> buildSpecification(GetSongByPageRequest request) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (!Utils.isNull(request.getArtist())) {
                String artistToSearch = "%" + request.getArtist() + "%";
                predicates.add(builder
                        .like(root.get(SongEntity_.artist).get(ArtistEntity_.name), artistToSearch));
            }

            if (!Utils.isNull(request.getAlbum())) {
                String albumToSearch = "%" + request.getAlbum() + "%";
                predicates.add(builder
                        .like(root.get(SongEntity_.album).get(AlbumEntity_.name), albumToSearch));
            }

            if (!Utils.isNull(request.getGenre())) {
                String genreToSearch = "%" + request.getGenre() + "%";
                predicates.add(builder
                        .like(root.get(SongEntity_.genre).get(GenreEntity_.name), genreToSearch));
            }

            if (!Utils.isNull(request.getTitle())) {
                String[] words = request.getTitle().split(" ");
                for (String word : words) {
                    word = "%" + word + "%";
                    predicates.add(builder.or(
                            builder.like(root.get(SongEntity_.title), word)
                    ));
                }
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
