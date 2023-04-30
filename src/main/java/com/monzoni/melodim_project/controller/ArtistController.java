package com.monzoni.melodim_project.controller;

import com.monzoni.melodim_project.command.CreateArtistCommand;
import com.monzoni.melodim_project.command.GetAllArtistListCommand;
import com.monzoni.melodim_project.command.UpdateArtistCommand;
import com.monzoni.melodim_project.command.spec.SafeCommandExecutor;
import com.monzoni.melodim_project.dto.request.CreateArtistRequest;
import com.monzoni.melodim_project.dto.request.DefaultRequest;
import com.monzoni.melodim_project.dto.request.UpdateArtistRequest;
import com.monzoni.melodim_project.dto.response.CreateArtistResponse;
import com.monzoni.melodim_project.dto.response.GetAllArtistListResponse;
import com.monzoni.melodim_project.dto.response.UpdateArtistResponse;
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

    @GetMapping(value = "/GetAllArtistList", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetAllArtistListResponse getAllArtistList() throws Exception {
        (new SafeCommandExecutor<DefaultRequest, GetAllArtistListResponse>()).safeExecution(getAllArtistListCommand);
        return getAllArtistListCommand.getOutput();
    }
    @PostMapping(value = "/CreateArtist", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CreateArtistResponse createArtist(@Valid @RequestBody CreateArtistRequest request) throws Exception {
        createArtistCommand.setInput(request);
        (new SafeCommandExecutor<CreateArtistRequest, CreateArtistResponse>()).safeExecution(createArtistCommand);
        return createArtistCommand.getOutput();
    }
    @PutMapping(value = "/UpdateArtist", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UpdateArtistResponse updateArtist(@Valid @RequestBody UpdateArtistRequest request) throws Exception {
        updateArtistCommand.setInput(request);
        (new SafeCommandExecutor<UpdateArtistRequest, UpdateArtistResponse>()).safeExecution(updateArtistCommand);
        return updateArtistCommand.getOutput();
    }
}
