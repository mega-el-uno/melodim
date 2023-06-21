package com.monzoni.melodim_project.command.song;

import com.monzoni.melodim_project.command.spec.PostExecutorCommand;
import com.monzoni.melodim_project.command.spec.PreExecutorCommand;
import com.monzoni.melodim_project.command.spec.SafeAbstractCommand;
import com.monzoni.melodim_project.dto.request.song.GetSongByPageRequest;
import com.monzoni.melodim_project.dto.response.PaginationResponse;
import com.monzoni.melodim_project.dto.response.song.SongResponse;
import com.monzoni.melodim_project.service.SongService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetSongByPageCommand
        extends SafeAbstractCommand<GetSongByPageRequest, PaginationResponse<SongResponse>>
        implements PreExecutorCommand, PostExecutorCommand {

    private final SongService songService;

    @Override
    public void preExecute() {
        log.info("GetSongByPageCommand - PreExecute");
    }

    @Override
    protected void execute() {
        log.info("GetSongByPageCommand - PreExecute");
        this.output = songService.getSongByPage(this.input);
    }

    @Override
    public void postExecute() {
        log.info("GetSongByPageCommand - PreExecute");
    }

}
