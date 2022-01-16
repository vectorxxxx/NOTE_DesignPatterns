package com.vectorx.pattern.t20_state;

/**
 * 奖品领完状态类
 */
public class DispenseOutState implements State {
    private RaffleActivity raffleActivity;

    public DispenseOutState(RaffleActivity raffleActivity) {
        this.raffleActivity = raffleActivity;
    }

    @Override
    public Boolean reduceMoney() {
        System.out.println("今日奖品已领完，明天再来吧~");
        return false;
    }

    @Override
    public Boolean raffle() {
        System.out.println("今日奖品已领完，明天再来吧~");
        return false;
    }

    @Override
    public Boolean dispensePrize() {
        System.out.println("今日奖品已领完，明天再来吧~");
        return false;
    }
}
