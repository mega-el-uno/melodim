package com.monzoni.melodim_project.controller.song;

import com.monzoni.melodim_project.command.song.GetSongByIdCommand;
import com.monzoni.melodim_project.command.song.GetSongByPageCommand;
import com.monzoni.melodim_project.command.spec.SafeCommandExecutor;
import com.monzoni.melodim_project.controller.SongOrderCriteria;
import com.monzoni.melodim_project.controller.SortDirection;
import com.monzoni.melodim_project.controller.constant.SongConstant;
import com.monzoni.melodim_project.dto.request.song.GetSongByPageRequest;
import com.monzoni.melodim_project.dto.response.CommonResponse;
import com.monzoni.melodim_project.dto.response.PaginationResponse;
import com.monzoni.melodim_project.dto.response.song.SongResponse;
import com.monzoni.melodim_project.util.function.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Api(tags = SongConstant.TAG_NAME, description = SongConstant.TAG_DESCRIPTION)
@RequestMapping(value = SongConstant.BASE_PATH)
@RestController
@RequiredArgsConstructor
public class GetSongController {

    private final GetSongByIdCommand getSongByIdCommand;
    private final GetSongByPageCommand getSongByPageCommand;

    @GetMapping(value = "/{id}")
    @ApiOperation(value = SongConstant.TAG_GET_SONG)
    CommonResponse<SongResponse> getSongById(@PathVariable Integer id) {
        getSongByIdCommand.setInput(id);
        (new SafeCommandExecutor<Integer, SongResponse>()).safeExecution(getSongByIdCommand);
        return new CommonResponse<>(getSongByIdCommand.getOutput());
    }

    @GetMapping
    @ApiOperation(value = SongConstant.TAG_GET_SONG + "by page")
    CommonResponse<PaginationResponse<SongResponse>> getSongByPage(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "ASC") SortDirection direction,
            @RequestParam(required = false) SongOrderCriteria order,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String artist,
            @RequestParam(required = false) String album,
            @RequestParam(required = false) String genre
    ) {
        GetSongByPageRequest request = GetSongByPageRequest.builder()
                .page(page)
                .size(size)
                .direction(direction)
                .order(!Utils.isNull(order) ? order.getValue() : null)
                .title(title)
                .artist(artist)
                .album(album)
                .genre(genre)
                .build();
        getSongByPageCommand.setInput(request);
        (new SafeCommandExecutor<GetSongByPageRequest, PaginationResponse<SongResponse>>())
                .safeExecution(getSongByPageCommand);
        return new CommonResponse<>(getSongByPageCommand.getOutput());
    }


}
