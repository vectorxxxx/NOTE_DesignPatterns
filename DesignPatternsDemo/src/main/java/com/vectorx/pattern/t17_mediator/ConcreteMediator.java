package com.vectorx.pattern.t17_mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * 具体中介者
 */
public class ConcreteMediator extends Mediator {
    private Map<String, Colleague> colleagueMap;

    public ConcreteMediator() {
        this.colleagueMap = new HashMap<>();
    }

    @Override
    public void registerColleague(Colleague colleague) {
        colleagueMap.put(colleague.getClass().getSimpleName(), colleague);
    }

    @Override
    public void getMsg(Integer state, String name) {
        Colleague colleague = colleagueMap.get(name);
        if (colleague instanceof Alarm) {
            dealAlarm(state);
        } else if (colleague instanceof CoffeeMachine) {
            dealCoffeeMachine(state);
        } else if (colleague instanceof Curtain) {
            dealCurtain(state);
        } else if (colleague instanceof TV) {
            dealTV(state);
        }
    }

    /**
     * 闹铃响起后操作
     *
     * @param state
     */
    private void dealAlarm(Integer state) {
        if (Integer.valueOf(1).equals(state)) {
            ((Alarm) colleagueMap.get(Alarm.class.getSimpleName())).closeAlarm();
            ((CoffeeMachine) colleagueMap.get(CoffeeMachine.class.getSimpleName())).makeCoffee();
        }
    }

    /**
     * 咖啡机煮咖啡完毕后操作
     *
     * @param state
     */
    private void dealCoffeeMachine(Integer state) {
        if (Integer.valueOf(1).equals(state)) {
            ((Curtain) colleagueMap.get(Curtain.class.getSimpleName())).downCurtain();
        }
    }

    /**
     * 窗帘落下后操作
     *
     * @param state
     */
    private void dealCurtain(Integer state) {
        if (Integer.valueOf(0).equals(state)) {
            TV tv = (TV) colleagueMap.get(TV.class.getSimpleName());
            tv.openTV();
            tv.switchChannel(101);
        }
    }

    /**
     * 电视关闭后操作
     *
     * @param state
     */
    private void dealTV(Integer state) {
        if (Integer.valueOf(0).equals(state)) {
            ((Curtain) colleagueMap.get(Curtain.class.getSimpleName())).upCurtain();
        }
    }

    @Override
    public void sendMsg() {
        // Do Nothing...
    }
}
