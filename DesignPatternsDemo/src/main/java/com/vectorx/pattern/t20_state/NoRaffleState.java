package com.vectorx.pattern.t20_state;

/**
 * 不能抽奖状态类
 */
public class NoRaffleState implements State {
    private RaffleActivity raffleActivity;
    // 模拟数据库积分值
    private int integral = 100;

    public NoRaffleState(RaffleActivity raffleActivity) {
        this.raffleActivity = raffleActivity;
    }

    @Override
    public Boolean reduceMoney() {
        if (integral < 50) {
            System.out.println("您的积分余额不足~");
            return false;
        }
        integral -= 50;
        raffleActivity.setCanRaffleState();
        System.out.println("已扣除50积分，可以进行抽奖啦~");
        return true;
    }

    @Override
    public Boolean raffle() {
        System.out.println("当前无法进行抽奖~");
        return false;
    }

    @Override
    public Boolean dispensePrize() {
        System.out.println("当前无法领取奖品~");
        return false;
    }
}
