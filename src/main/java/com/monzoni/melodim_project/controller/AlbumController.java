package com.monzoni.melodim_project.controller;

import com.monzoni.melodim_project.command.album.CreateAlbumCommand;
import com.monzoni.melodim_project.command.album.GetAllAlbumListCommand;
import com.monzoni.melodim_project.command.spec.SafeCommandExecutor;
import com.monzoni.melodim_project.dto.request.DefaultRequest;
import com.monzoni.melodim_project.dto.request.album.CreateAlbumRequest;
import com.monzoni.melodim_project.dto.response.album.CreateAlbumResponse;
import com.monzoni.melodim_project.dto.response.album.GetAllAlbumListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AlbumController {
    private final GetAllAlbumListCommand getAllAlbumListCommand;
    private final CreateAlbumCommand createAlbumCommand;
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
}
