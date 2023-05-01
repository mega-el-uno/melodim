package com.monzoni.melodim_project.controller;

import com.monzoni.melodim_project.command.album.GetAllAlbumListCommand;
import com.monzoni.melodim_project.command.spec.SafeCommandExecutor;
import com.monzoni.melodim_project.dto.request.DefaultRequest;
import com.monzoni.melodim_project.dto.response.album.GetAllAlbumListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AlbumController {
    private final GetAllAlbumListCommand getAllAlbumListCommand;
    @GetMapping(value = "/GetAllAlbumList", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetAllAlbumListResponse getAllAlbumList() throws Exception {
        new SafeCommandExecutor<DefaultRequest, GetAllAlbumListResponse>().safeExecution(getAllAlbumListCommand);
        return getAllAlbumListCommand.getOutput();
    }
}
