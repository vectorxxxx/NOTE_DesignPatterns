package com.vectorx.pattern.t13_command;

public class Client {
    public static void main(String[] args) {
        // 初始化遥控器
        RemoteController remoteController = new RemoteController();
        // 操作电灯
        int no = 0;
        LightReceiver light = new LightReceiver();
        remoteController.setCommands(no, new LightOnCommand(light), new LightOffCommand(light));
        remoteController.onBtnCommand(no);
        remoteController.offBtnCommand(no);
        remoteController.undoBtnCommand();
        // 操作电视
        no = 1;
        TVReceiver tv = new TVReceiver();
        remoteController.setCommands(no, new TVOnCommand(tv), new TVOffCommand(tv));
        remoteController.onBtnCommand(no);
        remoteController.offBtnCommand(no);
        remoteController.undoBtnCommand();
    }
}
