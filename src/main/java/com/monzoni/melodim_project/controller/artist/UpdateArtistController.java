package com.monzoni.melodim_project.controller.artist;

import com.monzoni.melodim_project.command.artist.UpdateArtistCommand;
import com.monzoni.melodim_project.command.spec.SafeCommandExecutor;
import com.monzoni.melodim_project.controller.constant.ArtistConstant;
import com.monzoni.melodim_project.dto.request.artist.UpdateArtistRequest;
import com.monzoni.melodim_project.dto.response.CommonResponse;
import com.monzoni.melodim_project.dto.response.album.AlbumResponse;
import com.monzoni.melodim_project.dto.response.artist.ArtistResponse;
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
@RequestMapping(value = ArtistConstant.BASE_PATH)
@RestController
@RequiredArgsConstructor
public class UpdateArtistController {

    private final UpdateArtistCommand updateArtistCommand;

    @PutMapping()
    @ApiOperation(value = ArtistConstant.TAG_UPDATE_ARTIST)
    public CommonResponse<ArtistResponse> updateArtist(@Valid @RequestBody UpdateArtistRequest request) {
        updateArtistCommand.setInput(request);
        (new SafeCommandExecutor<UpdateArtistRequest, ArtistResponse>()).safeExecution(updateArtistCommand);
        return new CommonResponse<>(updateArtistCommand.getOutput());
    }
}
