package com.limingjian.state;

/**
 * @author limingjian
 * @date 2020/6/10
 * 将所有的方法均委托给成员变量state。从而解耦各个状态
 */
public class GumballMachine {
    IState soldOutState;
    IState noQuarterState;
    IState hasQuarterState;
    IState soldState;
    IState state = soldState;

    int count = 0;

    public GumballMachine(int numberGumballs) {
        noQuarterState = new NoQuaterState(this);
        this.count = numberGumballs;

        if (this.count > 0) {
            state = noQuarterState;
        }
    }


    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public IState getHasQuarterState() {
        return this.hasQuarterState;
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    /**
     * 辅助方法，用来吐出糖果
     */
    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count = count - 1;
        }
    }

    public void setState(IState state) {
        this.state = state;
    }
}