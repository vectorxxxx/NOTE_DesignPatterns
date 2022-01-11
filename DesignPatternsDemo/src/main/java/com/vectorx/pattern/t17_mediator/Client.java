package com.vectorx.pattern.t17_mediator;

public class Client {
    public static void main(String[] args) {
        //创建中介者
        Mediator mediator = new ConcreteMediator();

        //创建各个同事类，并加入Mediator中介者的Map对象中
        Alarm alarm = new Alarm(mediator);
        CoffeeMachine coffeeMachine = new CoffeeMachine(mediator);
        Curtain curtain = new Curtain(mediator);
        TV tv = new TV(mediator);

        //闹钟响起
        alarm.openAlarm();
        coffeeMachine.completeCoffee();
        tv.closeTV();

        //>>>闹铃响起
        //>>>闹铃关闭
        //>>>煮咖啡中...
        //>>>咖啡已煮好
        //>>>拉下窗帘...
        //>>>打开电视...
        //>>>切换频道：101
        //>>>关闭电视...
        //>>>拉起窗帘...
    }
}
