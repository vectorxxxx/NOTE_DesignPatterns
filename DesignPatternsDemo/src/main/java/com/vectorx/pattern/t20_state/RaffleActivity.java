package com.vectorx.pattern.t20_state;

/**
 * 抽奖活动类
 */
public class RaffleActivity {
    /**
     * 奖品数量
     */
    private Integer count;
    /**
     * 不能抽奖状态
     */
    private State noRaffleState;
    /**
     * 可以抽奖状态
     */
    private State canRaffleState;
    /**
     * 发放奖品状态
     */
    private State dispenseState;
    /**
     * 奖品领完状态
     */
    private State dispenseOutState;
    /**
     * 当前状态
     */
    private State state;

    public RaffleActivity(Integer count) {
        this.count = count;
        noRaffleState = new NoRaffleState(this);
        canRaffleState = new CanRaffleState(this);
        dispenseState = new DispenseState(this);
        dispenseOutState = new DispenseOutState(this);
        this.state = noRaffleState;
    }

    /**
     * 进行抽奖
     */
    public void raffle() {
        if (state.reduceMoney()) {
            if (state.raffle()) {
                state.dispensePrize();
            }
        }
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setNoRaffleState() {
        this.state = noRaffleState;
    }

    public void setCanRaffleState() {
        this.state = canRaffleState;
    }

    public void setDispenseState() {
        this.state = dispenseState;
    }

    public void setDispenseOutState() {
        this.state = dispenseOutState;
    }

    public State getState() {
        return state;
    }
}
