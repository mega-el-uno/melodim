package com.monzoni.melodim_project.controller.song;

import com.monzoni.melodim_project.command.song.CreateSongCommand;
import com.monzoni.melodim_project.command.spec.SafeCommandExecutor;
import com.monzoni.melodim_project.controller.constant.MemberConstant;
import com.monzoni.melodim_project.controller.constant.SongConstant;
import com.monzoni.melodim_project.dto.request.song.CreateSongRequest;
import com.monzoni.melodim_project.dto.response.CommonResponse;
import com.monzoni.melodim_project.dto.response.song.SongResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = SongConstant.TAG_NAME, description = SongConstant.TAG_DESCRIPTION)
@RequestMapping(value = SongConstant.BASE_PATH)
@RestController
@RequiredArgsConstructor
public class CreateSongController {

    private final CreateSongCommand createSongCommand;

    @PostMapping()
    @ApiOperation(value = MemberConstant.TAG_CREATE_MEMBER)
    CommonResponse<SongResponse> createSong(@Valid @RequestBody CreateSongRequest request) {
        createSongCommand.setInput(request);
        (new SafeCommandExecutor<CreateSongRequest, SongResponse>()).safeExecution(createSongCommand);
        return new CommonResponse<>(createSongCommand.getOutput());
    }

}
