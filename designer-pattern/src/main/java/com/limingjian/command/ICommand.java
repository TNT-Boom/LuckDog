package com.limingjian.command;

/**
 * 命令模式，对每一个命令，均实现此接口，由execute去执行真正的需要执行的逻辑。
 * 类似线程池那种提交任务一样，调用者和执行者解耦。
 * @author lmj
 * @since 2020/6/7
 **/
public interface ICommand {
    public void execute();
}
