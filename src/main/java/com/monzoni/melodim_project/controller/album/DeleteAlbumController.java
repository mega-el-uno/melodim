package com.monzoni.melodim_project.controller.album;

import com.monzoni.melodim_project.command.album.DeleteAlbumCommand;
import com.monzoni.melodim_project.command.spec.SafeCommandExecutor;
import com.monzoni.melodim_project.controller.constant.AlbumConstant;
import com.monzoni.melodim_project.dto.response.CommonResponse;
import com.monzoni.melodim_project.dto.response.album.AlbumResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
