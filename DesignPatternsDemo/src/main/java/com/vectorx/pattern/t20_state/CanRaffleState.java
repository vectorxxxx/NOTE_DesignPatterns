package com.vectorx.pattern.t20_state;

import java.util.Random;

/**
 * 可以抽奖状态类
 */
public class CanRaffleState implements State {
    private RaffleActivity raffleActivity;

    public CanRaffleState(RaffleActivity raffleActivity) {
        this.raffleActivity = raffleActivity;
    }

    @Override
    public Boolean reduceMoney() {
        System.out.println("已扣除50积分，可以进行抽奖啦~");
        return false;
    }

    @Override
    public Boolean raffle() {
        if (new Random().nextInt(10) == 0) {
            raffleActivity.setDispenseState();
            System.out.println("恭喜您，中奖了~");
            return true;
        }
        raffleActivity.setNoRaffleState();
        System.out.println("很遗憾，您没有中奖~");
        return false;
    }

    @Override
    public Boolean dispensePrize() {
        System.out.println("尚未进行抽奖，无法领取奖品！");
        return false;
    }
}
