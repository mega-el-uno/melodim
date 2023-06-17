package com.monzoni.melodim_project.controller.song;

import com.monzoni.melodim_project.command.song.GetSongByIdCommand;
import com.monzoni.melodim_project.command.spec.SafeCommandExecutor;
import com.monzoni.melodim_project.controller.constant.SongConstant;
import com.monzoni.melodim_project.dto.response.CommonResponse;
import com.monzoni.melodim_project.dto.response.song.SongResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = SongConstant.TAG_NAME, description = SongConstant.TAG_DESCRIPTION)
@RequestMapping(value = SongConstant.BASE_PATH)
@RestController
@RequiredArgsConstructor
public class GetSongController {

    private final GetSongByIdCommand getSongByIdCommand;

    @GetMapping(value = "/{id}")
    @ApiOperation(value = SongConstant.TAG_GET_SONG)
    CommonResponse<SongResponse> getSongById(@PathVariable Integer id){
        getSongByIdCommand.setInput(id);
        (new SafeCommandExecutor<Integer, SongResponse>()).safeExecution(getSongByIdCommand);
        return new CommonResponse<>(getSongByIdCommand.getOutput());
    }

}
