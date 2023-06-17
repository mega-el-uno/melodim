package com.monzoni.melodim_project.command.song;

import com.monzoni.melodim_project.command.spec.PostExecutorCommand;
import com.monzoni.melodim_project.command.spec.PreExecutorCommand;
import com.monzoni.melodim_project.command.spec.SafeAbstractCommand;
import com.monzoni.melodim_project.dto.request.song.UpdateSongRequest;
import com.monzoni.melodim_project.dto.response.song.SongResponse;
import com.monzoni.melodim_project.service.SongService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UpdateSongCommand
        extends SafeAbstractCommand<UpdateSongRequest, SongResponse>
        implements PreExecutorCommand, PostExecutorCommand {

    private final SongService songService;

    @Override
    public void preExecute() {
        log.info("UpdateSongCommand - PreExecute");
    }

    @Override
    protected void execute() {
        log.info("UpdateSongCommand - Execute");
        this.output = songService.updateSong(this.input);
    }

    @Override
    public void postExecute() {
        log.info("UpdateSongCommand - PostExecute");
    }

}
