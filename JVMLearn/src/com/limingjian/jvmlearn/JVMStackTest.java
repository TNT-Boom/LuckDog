package com.limingjian.jvmlearn;

/*
 * 测试虚拟机栈与本地方法栈溢出
 * 参数 -Xss128k
 * 抛L stackoverflow 异常
 */
public class JVMStackTest
{
	private int stackLength = 1;
	
	public void stackLeak()
	{
		++stackLength;
		stackLeak();
	}
}
