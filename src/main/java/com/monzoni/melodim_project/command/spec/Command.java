package com.monzoni.melodim_project.command.spec;

public interface Command<I, O> {
    void setInput(I input);

    O getOutput();

    void execute();
}
