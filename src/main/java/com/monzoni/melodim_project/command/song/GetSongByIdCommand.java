package com.monzoni.melodim_project.command.song;

import com.monzoni.melodim_project.command.spec.PostExecutorCommand;
import com.monzoni.melodim_project.command.spec.PreExecutorCommand;
import com.monzoni.melodim_project.command.spec.SafeAbstractCommand;
import com.monzoni.melodim_project.dto.response.song.SongResponse;
import com.monzoni.melodim_project.exception.ProcessErrorException;
import com.monzoni.melodim_project.service.SongService;
import com.monzoni.melodim_project.util.function.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetSongByIdCommand
        extends SafeAbstractCommand<Integer, SongResponse>
        implements PreExecutorCommand, PostExecutorCommand {

    private final SongService songService;

    @Override
    public void preExecute() {
        log.info("SongService - PreExecute");
        if (Utils.isNull(this.input)){
            throw new ProcessErrorException("The id cannot be null");
        }
    }

    @Override
    protected void execute() {
        log.info("SongService - Execute");
        this.output = songService.getSongById(this.input);
    }

    @Override
    public void postExecute() {
        log.info("SongService - PostExecute");
    }

}
