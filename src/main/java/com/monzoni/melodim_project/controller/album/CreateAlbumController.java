package com.monzoni.melodim_project.controller.album;

import com.monzoni.melodim_project.command.album.CreateAlbumCommand;
import com.monzoni.melodim_project.command.spec.SafeCommandExecutor;
import com.monzoni.melodim_project.dto.request.album.CreateAlbumRequest;
import com.monzoni.melodim_project.dto.response.album.CreateAlbumResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class CreateAlbumController {
    private final CreateAlbumCommand createAlbumCommand;
    @PostMapping(value = "/CreateAlbum", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CreateAlbumResponse createAlbum(@Valid @RequestBody CreateAlbumRequest createAlbumRequest) {
        createAlbumCommand.setInput(createAlbumRequest);
        new SafeCommandExecutor<CreateAlbumRequest, CreateAlbumResponse>().safeExecution(createAlbumCommand);
        return createAlbumCommand.getOutput();
    }
}

