package com.monzoni.melodim_project.controller.album;

import com.monzoni.melodim_project.command.album.UpdateAlbumCommand;
import com.monzoni.melodim_project.command.spec.SafeCommandExecutor;
import com.monzoni.melodim_project.controller.constant.AlbumConstant;
import com.monzoni.melodim_project.dto.request.album.UpdateAlbumRequest;
import com.monzoni.melodim_project.dto.response.CommonResponse;
import com.monzoni.melodim_project.dto.response.album.AlbumResponse;
import com.monzoni.melodim_project.dto.response.album.UpdateAlbumResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = AlbumConstant.TAG_NAME, description = AlbumConstant.TAG_DESCRIPTION)
@RequestMapping(value = AlbumConstant.BASE_PATH)
@RestController
@RequiredArgsConstructor
public class UpdateAlbumController {
    private final UpdateAlbumCommand updateAlbumCommand;

    @PutMapping()
    @ApiOperation(value = AlbumConstant.TAG_UPDATE_ALBUM)
    public CommonResponse<AlbumResponse> updateAlbum(@Valid @RequestBody UpdateAlbumRequest updateAlbumRequest) {
        updateAlbumCommand.setInput(updateAlbumRequest);
        new SafeCommandExecutor<UpdateAlbumRequest, AlbumResponse>().safeExecution(updateAlbumCommand);
        return new CommonResponse<>(updateAlbumCommand.getOutput());
    }
}
