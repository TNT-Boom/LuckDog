package com.limingjian.command;

/**
 * @author limingjian
 * @date 2020/6/7
 *
 */
public class SimpleRemoteControl {
    ICommand slot;

    public SimpleRemoteControl(){}

    public void setCommand(ICommand command){
        this.slot = command;
    }

    public void buttonWasPressed(){
        slot.execute();
    }
}