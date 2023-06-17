package com.monzoni.melodim_project.controller.artist;

import com.monzoni.melodim_project.command.artist.CreateArtistCommand;
import com.monzoni.melodim_project.command.spec.SafeCommandExecutor;
import com.monzoni.melodim_project.controller.constant.ArtistConstant;
import com.monzoni.melodim_project.dto.request.artist.CreateArtistRequest;
import com.monzoni.melodim_project.dto.response.artist.CreateArtistResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = ArtistConstant.TAG_NAME, description = ArtistConstant.TAG_DESCRIPTION)
@RequestMapping(name = ArtistConstant.BASE_PATH)
@RestController
@RequiredArgsConstructor
public class CreateArtistController {

    private CreateArtistCommand createArtistCommand;

    @ApiOperation(value = ArtistConstant.TAG_CREATE_ARTIST)
    @PostMapping(value = "/CreateArtist", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CreateArtistResponse createArtist(@Valid @RequestBody CreateArtistRequest request) {
        createArtistCommand.setInput(request);
        (new SafeCommandExecutor<CreateArtistRequest, CreateArtistResponse>()).safeExecution(createArtistCommand);
        return createArtistCommand.getOutput();
    }
}
