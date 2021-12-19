package com.vectorx.pattern.t13_command;

/**
 * 命令角色
 */
public interface Command {
    void execute();

    void undo();
}