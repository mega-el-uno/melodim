package com.monzoni.melodim_project.controller;

import com.monzoni.melodim_project.command.album.CreateAlbumCommand;
import com.monzoni.melodim_project.command.album.DeleteAlbumCommand;
import com.monzoni.melodim_project.command.album.GetAllAlbumListCommand;
import com.monzoni.melodim_project.command.album.UpdateAlbumCommand;
import com.monzoni.melodim_project.command.spec.SafeCommandExecutor;
import com.monzoni.melodim_project.dto.request.DefaultRequest;
import com.monzoni.melodim_project.dto.request.album.CreateAlbumRequest;
import com.monzoni.melodim_project.dto.request.album.DeleteAlbumRequest;
import com.monzoni.melodim_project.dto.request.album.UpdateAlbumRequest;
import com.monzoni.melodim_project.dto.response.album.CreateAlbumResponse;
import com.monzoni.melodim_project.dto.response.album.DeleteAlbumResponse;
import com.monzoni.melodim_project.dto.response.album.GetAllAlbumListResponse;
import com.monzoni.melodim_project.dto.response.album.UpdateAlbumResponse;
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
    private final DeleteAlbumCommand deleteAlbumCommand;

    @GetMapping(value = "/GetAllAlbumList", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetAllAlbumListResponse getAllAlbumList() {
        new SafeCommandExecutor<DefaultRequest, GetAllAlbumListResponse>().safeExecution(getAllAlbumListCommand);
        return getAllAlbumListCommand.getOutput();
    }

    @PostMapping(value = "/CreateAlbum", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CreateAlbumResponse createAlbum(@Valid @RequestBody CreateAlbumRequest createAlbumRequest) {
        createAlbumCommand.setInput(createAlbumRequest);
        new SafeCommandExecutor<CreateAlbumRequest, CreateAlbumResponse>().safeExecution(createAlbumCommand);
        return createAlbumCommand.getOutput();
    }

    @PutMapping(value = "/UpdateAlbum", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UpdateAlbumResponse updateAlbum(@Valid @RequestBody UpdateAlbumRequest updateAlbumRequest) {
        updateAlbumCommand.setInput(updateAlbumRequest);
        new SafeCommandExecutor<UpdateAlbumRequest, UpdateAlbumResponse>().safeExecution(updateAlbumCommand);
        return updateAlbumCommand.getOutput();
    }

    @DeleteMapping(value = "/DeleteAlbum", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DeleteAlbumResponse deleteAlbum(@Valid @RequestBody DeleteAlbumRequest deleteAlbumRequest) {
        deleteAlbumCommand.setInput(deleteAlbumRequest);
        new SafeCommandExecutor<DeleteAlbumRequest, DeleteAlbumResponse>().safeExecution(deleteAlbumCommand);
        return deleteAlbumCommand.getOutput();
    }
}
