package com.vectorx.pattern.t13_command;

/**
 * 具体的命令角色
 */
public class TVOffCommand implements Command {
    /**
     * 接收者
     */
    private TVReceiver tv;

    public TVOffCommand(TVReceiver tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.off();
    }

    @Override
    public void undo() {
        tv.on();
    }
}
