package com.monzoni.melodim_project.command.spec;

public abstract class Command<I, O> {
    protected I input;
    protected O output;

    public void setInput(I input) {
        this.input = input;
    }

    public O getOutput() {
        return this.output;
    }

    abstract protected void execute();
}
