package com.monzoni.melodim_project.controller.song;

import com.monzoni.melodim_project.command.song.DeleteSongCommand;
import com.monzoni.melodim_project.command.spec.SafeCommandExecutor;
import com.monzoni.melodim_project.controller.constant.SongConstant;
import com.monzoni.melodim_project.dto.response.CommonResponse;
import com.monzoni.melodim_project.dto.response.song.SongResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = SongConstant.TAG_NAME, description = SongConstant.TAG_DESCRIPTION)
@RequestMapping(value = SongConstant.BASE_PATH)
@RestController
@RequiredArgsConstructor
public class DeleteSongController {

    private final DeleteSongCommand deleteSongCommand;

    @PutMapping(value = "/{id}")
    @ApiOperation(value = SongConstant.TAG_DELETE_SONG)
    CommonResponse<SongResponse> deleteSongById(@PathVariable Integer id){
        deleteSongCommand.setInput(id);
        (new SafeCommandExecutor<Integer, SongResponse>()).safeExecution(deleteSongCommand);
        return new CommonResponse<>(deleteSongCommand.getOutput());
    }

}
