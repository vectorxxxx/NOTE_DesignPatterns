package com.vectorx.pattern.t20_state;

public class Client {
    public static void main(String[] args) {
        RaffleActivity raffleActivity = new RaffleActivity(2);
        // 第一次抽奖
        System.out.println("======第一次抽奖======");
        raffleActivity.raffle();
        // 第二次抽奖
        System.out.println("======第二次抽奖======");
        raffleActivity.raffle();
        // 第三次抽奖
        System.out.println("======第三次抽奖======");
        raffleActivity.raffle();
        //======第一次抽奖======
        //已扣除50积分，可以进行抽奖啦~
        //很遗憾，您没有中奖~
        //======第二次抽奖======
        //已扣除50积分，可以进行抽奖啦~
        //恭喜您，中奖了~
        //奖品领取成功~
        //======第三次抽奖======
        //您的积分余额不足~
    }
}
