package com.limingjian.state;

/**
 * 所有的状态都实现此接口，此接口具有一个机器所有的状态对应的方法
 * @author lmj
 * @since 2020/6/10
 **/
public interface IState {
    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();
}
