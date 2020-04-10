package com.limingjian.jvmlearn;

/*
 * ���������ջ�뱾�ط���ջ���
 * ���� -Xss2M // ջԽ������߳�Խ���ױ��ڴ�
 * ��L outofmemory �쳣
 */
public class JavaVMStackOOM
{
	private void dontStop()
	{
		while(true){}
	}
	
	public void stackLeakByThread()
	{
		while(true)
		{
			Thread thread = new Thread(new Runnable()
			{
				
				@Override
				public void run()
				{
					dontStop();
					
				}
			});
			thread.start();
		}
	}
}
