package com.monzoni.melodim_project.controller.album;

import com.monzoni.melodim_project.command.album.CreateAlbumCommand;
import com.monzoni.melodim_project.command.spec.SafeCommandExecutor;
import com.monzoni.melodim_project.controller.constant.AlbumConstant;
import com.monzoni.melodim_project.dto.request.album.CreateAlbumRequest;
import com.monzoni.melodim_project.dto.response.CommonResponse;
import com.monzoni.melodim_project.dto.response.album.AlbumResponse;
import com.monzoni.melodim_project.dto.response.album.CreateAlbumResponse;
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
public class CreateAlbumController {
    private final CreateAlbumCommand createAlbumCommand;

    @PostMapping()
    @ApiOperation(value = AlbumConstant.TAG_CREATE_ALBUM)
    @ResponseStatus(HttpStatus.CREATED)
    public CommonResponse<AlbumResponse> createAlbum(@Valid @RequestBody CreateAlbumRequest createAlbumRequest) {
        createAlbumCommand.setInput(createAlbumRequest);
        new SafeCommandExecutor<CreateAlbumRequest, AlbumResponse>().safeExecution(createAlbumCommand);
        return new CommonResponse<>(createAlbumCommand.getOutput(), HttpStatus.CREATED, HttpStatus.CREATED.name());
    }
}

