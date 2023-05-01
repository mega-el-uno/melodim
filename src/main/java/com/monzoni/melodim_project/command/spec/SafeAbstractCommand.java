package com.monzoni.melodim_project.command.spec;


import com.monzoni.melodim_project.exception.CommandException;

public abstract class SafeAbstractCommand<I, O> extends Command<I, O> {
    public void safeExecute() throws CommandException {
        try {
            this.execute();
        } catch (Exception exception) {
            throw new CommandException(exception);
        }
    }
}
