package com.limingjian.command;

/**
 * @author limingjian
 * @date 2020/6/7
 *
 */
public class LightOnCommand implements ICommand{
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }
    @Override
    public void execute() {
        light.on();
    }
}