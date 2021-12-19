package com.vectorx.pattern.t13_command;

/**
 * 具体的命令角色
 */
public class LightOnCommand implements Command{
    /**
     * 接收者
     */
    private LightReceiver light;

    public LightOnCommand(LightReceiver light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
