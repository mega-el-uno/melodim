package com.monzoni.melodim_project.controller.album;

import com.monzoni.melodim_project.command.album.DeleteAlbumCommand;
import com.monzoni.melodim_project.command.spec.SafeCommandExecutor;
import com.monzoni.melodim_project.controller.constant.AlbumConstant;
import com.monzoni.melodim_project.dto.request.album.DeleteAlbumRequest;
import com.monzoni.melodim_project.dto.response.album.DeleteAlbumResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = AlbumConstant.TAG_NAME, description = AlbumConstant.TAG_DESCRIPTION)
@RequestMapping(name = AlbumConstant.BASE_PATH)
@RestController
@RequiredArgsConstructor
public class DeleteAlbumController {

    private final DeleteAlbumCommand deleteAlbumCommand;

    @ApiOperation(value = AlbumConstant.TAG_DELETE_ALBUM)
    @DeleteMapping(value = "/DeleteAlbum", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DeleteAlbumResponse deleteAlbum(@Valid @RequestBody DeleteAlbumRequest deleteAlbumRequest) {
        deleteAlbumCommand.setInput(deleteAlbumRequest);
        new SafeCommandExecutor<DeleteAlbumRequest, DeleteAlbumResponse>().safeExecution(deleteAlbumCommand);
        return deleteAlbumCommand.getOutput();
    }
}
