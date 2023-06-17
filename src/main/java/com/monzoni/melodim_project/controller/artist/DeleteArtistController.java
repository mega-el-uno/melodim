package com.monzoni.melodim_project.controller.artist;

import com.monzoni.melodim_project.command.artist.DeleteArtistCommand;
import com.monzoni.melodim_project.command.spec.SafeCommandExecutor;
import com.monzoni.melodim_project.controller.constant.ArtistConstant;
import com.monzoni.melodim_project.dto.response.CommonResponse;
import com.monzoni.melodim_project.dto.response.artist.ArtistResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = ArtistConstant.TAG_NAME, description = ArtistConstant.TAG_DESCRIPTION)
@RequestMapping(value = ArtistConstant.BASE_PATH)
@RestController
@RequiredArgsConstructor
public class DeleteArtistController {

    private final DeleteArtistCommand deleteArtistCommand;

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = ArtistConstant.TAG_DELETE_ARTIST)
    public CommonResponse<ArtistResponse> deleteArtist(@PathVariable Integer id) {
        deleteArtistCommand.setInput(id);
        (new SafeCommandExecutor<Integer, ArtistResponse>()).safeExecution(deleteArtistCommand);
        return new CommonResponse<>(deleteArtistCommand.getOutput());
    }
}
