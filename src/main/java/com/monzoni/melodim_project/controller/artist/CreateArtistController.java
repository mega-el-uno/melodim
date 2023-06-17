package com.monzoni.melodim_project.controller.artist;

import com.monzoni.melodim_project.command.artist.CreateArtistCommand;
import com.monzoni.melodim_project.command.spec.SafeCommandExecutor;
import com.monzoni.melodim_project.controller.constant.ArtistConstant;
import com.monzoni.melodim_project.dto.request.artist.CreateArtistRequest;
import com.monzoni.melodim_project.dto.response.CommonResponse;
import com.monzoni.melodim_project.dto.response.artist.ArtistResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = ArtistConstant.TAG_NAME, description = ArtistConstant.TAG_DESCRIPTION)
@RequestMapping(value = ArtistConstant.BASE_PATH)
@RestController
@RequiredArgsConstructor
public class CreateArtistController {

    private CreateArtistCommand createArtistCommand;

    @PostMapping()
    @ApiOperation(value = ArtistConstant.TAG_CREATE_ARTIST)
    public CommonResponse<ArtistResponse> createArtist(@Valid @RequestBody CreateArtistRequest request) {
        createArtistCommand.setInput(request);
        (new SafeCommandExecutor<CreateArtistRequest, ArtistResponse>()).safeExecution(createArtistCommand);
        return new CommonResponse<>(createArtistCommand.getOutput());
    }
}
