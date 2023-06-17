package com.monzoni.melodim_project.controller.artist;

import com.monzoni.melodim_project.command.artist.UpdateArtistCommand;
import com.monzoni.melodim_project.command.spec.SafeCommandExecutor;
import com.monzoni.melodim_project.controller.constant.ArtistConstant;
import com.monzoni.melodim_project.dto.request.artist.UpdateArtistRequest;
import com.monzoni.melodim_project.dto.response.artist.UpdateArtistResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = ArtistConstant.TAG_NAME, description = ArtistConstant.TAG_DESCRIPTION)
@RequestMapping(name = ArtistConstant.BASE_PATH)
@RestController
@RequiredArgsConstructor
public class UpdateArtistController {
    private final UpdateArtistCommand updateArtistCommand;

    @ApiOperation(value = ArtistConstant.TAG_UPDATE_ARTIST)
    @PutMapping(value = "/UpdateArtist", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UpdateArtistResponse updateArtist(@Valid @RequestBody UpdateArtistRequest request) {
        updateArtistCommand.setInput(request);
        (new SafeCommandExecutor<UpdateArtistRequest, UpdateArtistResponse>()).safeExecution(updateArtistCommand);
        return updateArtistCommand.getOutput();
    }
}
