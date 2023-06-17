package com.monzoni.melodim_project.controller.album;

import com.monzoni.melodim_project.command.album.DeleteAlbumCommand;
import com.monzoni.melodim_project.command.spec.SafeCommandExecutor;
import com.monzoni.melodim_project.controller.constant.AlbumConstant;
import com.monzoni.melodim_project.dto.request.album.DeleteAlbumRequest;
import com.monzoni.melodim_project.dto.response.CommonResponse;
import com.monzoni.melodim_project.dto.response.album.AlbumResponse;
import com.monzoni.melodim_project.dto.response.album.DeleteAlbumResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = AlbumConstant.TAG_NAME, description = AlbumConstant.TAG_DESCRIPTION)
@RequestMapping(value = AlbumConstant.BASE_PATH)
@RestController
@RequiredArgsConstructor
public class DeleteAlbumController {

    private final DeleteAlbumCommand deleteAlbumCommand;

    @DeleteMapping(value = "/{albumId}")
    @ApiOperation(value = AlbumConstant.TAG_DELETE_ALBUM)
    public CommonResponse<AlbumResponse> deleteAlbum(@PathVariable Integer albumId) {
        deleteAlbumCommand.setInput(albumId);
        new SafeCommandExecutor<Integer, AlbumResponse>().safeExecution(deleteAlbumCommand);
        return new CommonResponse<>(deleteAlbumCommand.getOutput());
    }
}
