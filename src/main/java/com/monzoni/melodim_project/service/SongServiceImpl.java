package com.monzoni.melodim_project.service;

import com.monzoni.melodim_project.dto.request.song.CreateSongRequest;
import com.monzoni.melodim_project.dto.request.song.UpdateSongRequest;
import com.monzoni.melodim_project.dto.response.song.SongResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService{

    @Override
    public List<SongResponse> getAllSongList() {
        return null;
    }

    @Override
    public SongResponse saveNewSong(CreateSongRequest createSongRequest) {
        return null;
    }

    @Override
    public SongResponse updateSong(UpdateSongRequest updateSongRequest) {
        return null;
    }

    @Override
    public SongResponse deleteSong(Integer id) {
        return null;
    }

    @Override
    public Boolean existSongById(Integer id) {
        return null;
    }

    @Override
    public SongResponse getSongById(Integer id) {
        return null;
    }
}
