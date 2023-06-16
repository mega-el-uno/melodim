package com.monzoni.melodim_project.controller.album;

import com.monzoni.melodim_project.command.album.UpdateAlbumCommand;
import com.monzoni.melodim_project.command.spec.SafeCommandExecutor;
import com.monzoni.melodim_project.dto.request.album.UpdateAlbumRequest;
import com.monzoni.melodim_project.dto.response.album.UpdateAlbumResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UpdateAlbumController {
    private final UpdateAlbumCommand updateAlbumCommand;

    @PutMapping(value = "/UpdateAlbum", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UpdateAlbumResponse updateAlbum(@Valid @RequestBody UpdateAlbumRequest updateAlbumRequest) {
        updateAlbumCommand.setInput(updateAlbumRequest);
        new SafeCommandExecutor<UpdateAlbumRequest, UpdateAlbumResponse>().safeExecution(updateAlbumCommand);
        return updateAlbumCommand.getOutput();
    }
}
