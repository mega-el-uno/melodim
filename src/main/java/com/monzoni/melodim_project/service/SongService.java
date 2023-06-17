package com.monzoni.melodim_project.service;

import com.monzoni.melodim_project.dto.request.song.CreateSongRequest;
import com.monzoni.melodim_project.dto.request.song.UpdateSongRequest;
import com.monzoni.melodim_project.dto.response.song.SongResponse;

import java.util.List;

public interface SongService {

    List<SongResponse> getAllSongList();

    SongResponse saveNewSong(CreateSongRequest createSongRequest);

    SongResponse updateSong(UpdateSongRequest updateSongRequest);

    SongResponse deleteSong(Integer id);

    Boolean existSongById(Integer id);

    SongResponse getSongById(Integer id);

}
