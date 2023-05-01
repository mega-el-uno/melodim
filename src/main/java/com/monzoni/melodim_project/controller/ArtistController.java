package com.monzoni.melodim_project.controller;

import com.monzoni.melodim_project.command.artist.CreateArtistCommand;
import com.monzoni.melodim_project.command.artist.DeleteArtistCommand;
import com.monzoni.melodim_project.command.artist.GetAllArtistListCommand;
import com.monzoni.melodim_project.command.artist.UpdateArtistCommand;
import com.monzoni.melodim_project.command.spec.SafeCommandExecutor;
import com.monzoni.melodim_project.dto.request.DefaultRequest;
import com.monzoni.melodim_project.dto.request.artist.CreateArtistRequest;
import com.monzoni.melodim_project.dto.request.artist.DeleteArtistRequest;
import com.monzoni.melodim_project.dto.request.artist.UpdateArtistRequest;
import com.monzoni.melodim_project.dto.response.artist.CreateArtistResponse;
import com.monzoni.melodim_project.dto.response.artist.DeleteArtistResponse;
import com.monzoni.melodim_project.dto.response.artist.GetAllArtistListResponse;
import com.monzoni.melodim_project.dto.response.artist.UpdateArtistResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ArtistController {
    private final GetAllArtistListCommand getAllArtistListCommand;
    private final CreateArtistCommand createArtistCommand;
    private final UpdateArtistCommand updateArtistCommand;
    private final DeleteArtistCommand deleteArtistCommand;

    @GetMapping(value = "/GetAllArtistList", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetAllArtistListResponse getAllArtistList() {
        (new SafeCommandExecutor<DefaultRequest, GetAllArtistListResponse>()).safeExecution(getAllArtistListCommand);
        return getAllArtistListCommand.getOutput();
    }

    @PostMapping(value = "/CreateArtist", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CreateArtistResponse createArtist(@Valid @RequestBody CreateArtistRequest request) {
        createArtistCommand.setInput(request);
        (new SafeCommandExecutor<CreateArtistRequest, CreateArtistResponse>()).safeExecution(createArtistCommand);
        return createArtistCommand.getOutput();
    }

    @PutMapping(value = "/UpdateArtist", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UpdateArtistResponse updateArtist(@Valid @RequestBody UpdateArtistRequest request) {
        updateArtistCommand.setInput(request);
        (new SafeCommandExecutor<UpdateArtistRequest, UpdateArtistResponse>()).safeExecution(updateArtistCommand);
        return updateArtistCommand.getOutput();
    }

    @DeleteMapping(value = "/DeleteArtist", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DeleteArtistResponse deleteArtist(@Valid @RequestBody DeleteArtistRequest request) {
        deleteArtistCommand.setInput(request);
        (new SafeCommandExecutor<DeleteArtistRequest, DeleteArtistResponse>()).safeExecution(deleteArtistCommand);
        return deleteArtistCommand.getOutput();
    }
}
