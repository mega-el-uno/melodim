package com.monzoni.melodim_project.command.spec;


public abstract class SafeAbstractCommand<I, O> extends Command<I, O> {
    public void safeExecute() throws Exception {
        try {
            this.execute();
        } catch (Exception exception) {
            throw new Exception(exception);
        }
    }

    public abstract void preExecute();

    public abstract void postExecute();
}
