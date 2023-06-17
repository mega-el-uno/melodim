package com.monzoni.melodim_project.controller.artist;

import com.monzoni.melodim_project.command.artist.DeleteArtistCommand;
import com.monzoni.melodim_project.command.spec.SafeCommandExecutor;
import com.monzoni.melodim_project.controller.constant.ArtistConstant;
import com.monzoni.melodim_project.dto.request.artist.DeleteArtistRequest;
import com.monzoni.melodim_project.dto.response.artist.DeleteArtistResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = ArtistConstant.TAG_NAME, description = ArtistConstant.TAG_DESCRIPTION)
@RequestMapping(name = ArtistConstant.BASE_PATH)
@RestController
@RequiredArgsConstructor
public class DeleteArtistController {
    private final DeleteArtistCommand deleteArtistCommand;

    @ApiOperation(value = ArtistConstant.TAG_DELETE_ARTIST)
    @DeleteMapping(value = "/DeleteArtist", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DeleteArtistResponse deleteArtist(@Valid @RequestBody DeleteArtistRequest request) {
        deleteArtistCommand.setInput(request);
        (new SafeCommandExecutor<DeleteArtistRequest, DeleteArtistResponse>()).safeExecution(deleteArtistCommand);
        return deleteArtistCommand.getOutput();
    }
}
