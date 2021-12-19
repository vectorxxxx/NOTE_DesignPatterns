package com.vectorx.pattern.t13_command;

/**
 * 具体的命令角色
 */
public class LightOffCommand implements Command {
    /**
     * 接收者
     */
    private LightReceiver light;

    public LightOffCommand(LightReceiver light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
