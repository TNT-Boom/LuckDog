package com.limingjian.state;

/**
 * @author limingjian
 * @date 2020/6/10
 *
 */
public class NoQuaterState implements IState {
    GumballMachine gumballMachine;

    public NoQuaterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("You inserted a quarter!");
        this.gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    public void ejectQuarter() {

    }

    public void turnCrank() {

    }

    public void dispense() {

    }
}