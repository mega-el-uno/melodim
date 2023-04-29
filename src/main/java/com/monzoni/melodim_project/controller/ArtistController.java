package com.monzoni.melodim_project.controller;

import com.monzoni.melodim_project.command.GetAllArtistListCommand;
import com.monzoni.melodim_project.command.spec.SafeCommandExecutor;
import com.monzoni.melodim_project.dto.request.GetAllArtistListRequest;
import com.monzoni.melodim_project.dto.response.GetAllArtistListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ArtistController {
    private final GetAllArtistListCommand getAllArtistListCommand;
    @GetMapping(value = "/GetAllArtistList", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public GetAllArtistListResponse getAllArtistList(@Valid @RequestBody GetAllArtistListRequest request) throws Exception {
        getAllArtistListCommand.setInput(request);
        (new SafeCommandExecutor<GetAllArtistListRequest, GetAllArtistListResponse>()).safeExecution(getAllArtistListCommand);
        return getAllArtistListCommand.getOutput();

    }
}
