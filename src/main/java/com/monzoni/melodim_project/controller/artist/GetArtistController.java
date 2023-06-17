package com.monzoni.melodim_project.controller.artist;

import com.monzoni.melodim_project.command.artist.GetAllArtistListCommand;
import com.monzoni.melodim_project.command.spec.SafeCommandExecutor;
import com.monzoni.melodim_project.controller.constant.ArtistConstant;
import com.monzoni.melodim_project.dto.request.DefaultRequest;
import com.monzoni.melodim_project.dto.response.artist.GetAllArtistListResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = ArtistConstant.TAG_NAME, description = ArtistConstant.TAG_DESCRIPTION)
@RequestMapping(name = ArtistConstant.BASE_PATH)
@RestController
@RequiredArgsConstructor
public class GetArtistController {
    private final GetAllArtistListCommand getAllArtistListCommand;

    @ApiOperation(value = ArtistConstant.TAG_GET_ARTIST)
    @GetMapping(value = "/GetAllArtistList", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetAllArtistListResponse getAllArtistList() {
        (new SafeCommandExecutor<DefaultRequest, GetAllArtistListResponse>()).safeExecution(getAllArtistListCommand);
        return getAllArtistListCommand.getOutput();
    }
}
