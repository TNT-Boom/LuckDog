package com.limingjian.jvmlearn;

/*
 * ���������ջ�뱾�ط���ջ���
 * ���� -Xss128k
 * ��L stackoverflow �쳣
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
