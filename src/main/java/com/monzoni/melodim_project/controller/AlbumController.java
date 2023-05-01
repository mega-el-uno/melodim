package com.monzoni.melodim_project.controller;

import com.monzoni.melodim_project.command.UpdateAlbumCommand;
import com.monzoni.melodim_project.command.album.CreateAlbumCommand;
import com.monzoni.melodim_project.command.album.GetAllAlbumListCommand;
import com.monzoni.melodim_project.command.spec.SafeCommandExecutor;
import com.monzoni.melodim_project.dto.request.DefaultRequest;
import com.monzoni.melodim_project.dto.request.album.CreateAlbumRequest;
import com.monzoni.melodim_project.dto.request.album.UpdateAlbumRequest;
import com.monzoni.melodim_project.dto.request.artist.UpdateArtistRequest;
import com.monzoni.melodim_project.dto.response.album.CreateAlbumResponse;
import com.monzoni.melodim_project.dto.response.album.GetAllAlbumListResponse;
import com.monzoni.melodim_project.dto.response.album.UpdateAlbumResponse;
import com.monzoni.melodim_project.dto.response.artist.UpdateArtistResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AlbumController {
    private final GetAllAlbumListCommand getAllAlbumListCommand;
    private final CreateAlbumCommand createAlbumCommand;
    private final UpdateAlbumCommand updateAlbumCommand;
    @GetMapping(value = "/GetAllAlbumList", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetAllAlbumListResponse getAllAlbumList() throws Exception {
        new SafeCommandExecutor<DefaultRequest, GetAllAlbumListResponse>().safeExecution(getAllAlbumListCommand);
        return getAllAlbumListCommand.getOutput();
    }
    @PostMapping(value = "/CreateAlbum",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CreateAlbumResponse createAlbum(@Valid @RequestBody CreateAlbumRequest createAlbumRequest) throws Exception {
        createAlbumCommand.setInput(createAlbumRequest);
        new SafeCommandExecutor<CreateAlbumRequest, CreateAlbumResponse>().safeExecution(createAlbumCommand);
        return createAlbumCommand.getOutput();
    }
    @PutMapping(value = "/UpdateAlbum",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UpdateAlbumResponse updateAlbum(@Valid @RequestBody UpdateAlbumRequest updateAlbumRequest) throws Exception {
        updateAlbumCommand.setInput(updateAlbumRequest);
        new SafeCommandExecutor<UpdateAlbumRequest, UpdateAlbumResponse>().safeExecution(updateAlbumCommand);
        return updateAlbumCommand.getOutput();
    }
}
