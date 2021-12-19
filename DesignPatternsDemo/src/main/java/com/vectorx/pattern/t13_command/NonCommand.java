package com.vectorx.pattern.t13_command;

/**
 * 空命令，什么也不干
 */
public class NonCommand implements Command {
    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
