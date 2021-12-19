package com.vectorx.pattern.t13_command;

/**
 * 具体的命令角色
 */
public class TVOnCommand implements Command {
    /**
     * 接收者
     */
    private TVReceiver tv;

    public TVOnCommand(TVReceiver tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.on();
    }

    @Override
    public void undo() {
        tv.off();
    }
}
