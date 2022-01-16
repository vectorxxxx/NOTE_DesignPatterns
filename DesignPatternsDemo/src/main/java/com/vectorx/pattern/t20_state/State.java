package com.vectorx.pattern.t20_state;

/**
 * 抽象状态角色
 */
public interface State {
    Boolean reduceMoney();

    Boolean raffle();

    Boolean dispensePrize();
}
