package com.monzoni.melodim_project.controller.song;

import com.monzoni.melodim_project.command.song.UpdateSongCommand;
import com.monzoni.melodim_project.command.spec.SafeCommandExecutor;
import com.monzoni.melodim_project.controller.constant.SongConstant;
import com.monzoni.melodim_project.dto.request.song.UpdateSongRequest;
import com.monzoni.melodim_project.dto.response.CommonResponse;
import com.monzoni.melodim_project.dto.response.song.SongResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = SongConstant.TAG_NAME, description = SongConstant.TAG_DESCRIPTION)
@RequestMapping(value = SongConstant.BASE_PATH)
@RestController
@RequiredArgsConstructor
public class UpdateSongController {

    private final UpdateSongCommand updateSongCommand;

    @PutMapping()
    @ApiOperation(value = SongConstant.TAG_UPDATE_SONG)
    CommonResponse<SongResponse> updateSong(@Valid @RequestBody UpdateSongRequest request){
        updateSongCommand.setInput(request);
        (new SafeCommandExecutor<UpdateSongRequest, SongResponse>()).safeExecution(updateSongCommand);
        return new CommonResponse<>(updateSongCommand.getOutput());
    }

}
