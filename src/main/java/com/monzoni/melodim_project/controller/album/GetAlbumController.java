package com.monzoni.melodim_project.controller.album;

import com.monzoni.melodim_project.command.album.GetAllAlbumListCommand;
import com.monzoni.melodim_project.command.spec.SafeCommandExecutor;
import com.monzoni.melodim_project.controller.constant.AlbumConstant;
import com.monzoni.melodim_project.dto.request.DefaultRequest;
import com.monzoni.melodim_project.dto.response.album.GetAllAlbumListResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = AlbumConstant.TAG_NAME, description = AlbumConstant.TAG_DESCRIPTION)
@RequestMapping(value = AlbumConstant.BASE_PATH)
@RestController
@RequiredArgsConstructor
public class GetAlbumController {
    private final GetAllAlbumListCommand getAllAlbumListCommand;

    @ApiOperation(value = AlbumConstant.TAG_GET_ALBUM)
    @GetMapping(value = "/GetAllAlbumList", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetAllAlbumListResponse getAllAlbumList() {
        new SafeCommandExecutor<DefaultRequest, GetAllAlbumListResponse>().safeExecution(getAllAlbumListCommand);
        return getAllAlbumListCommand.getOutput();
    }
}
