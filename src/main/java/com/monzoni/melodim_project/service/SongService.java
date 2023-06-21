package com.monzoni.melodim_project.service;

import com.monzoni.melodim_project.dto.request.song.CreateSongRequest;
import com.monzoni.melodim_project.dto.request.song.GetSongByPageRequest;
import com.monzoni.melodim_project.dto.request.song.UpdateSongRequest;
import com.monzoni.melodim_project.dto.response.PaginationResponse;
import com.monzoni.melodim_project.dto.response.song.SongResponse;

public interface SongService {

    SongResponse saveNewSong(CreateSongRequest createSongRequest);

    SongResponse updateSong(UpdateSongRequest updateSongRequest);

    SongResponse deleteSong(Integer id);

    Boolean existSongById(Integer id);

    SongResponse getSongById(Integer id);

    PaginationResponse<SongResponse> getSongByPage(GetSongByPageRequest request);
}
