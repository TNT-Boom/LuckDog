package parallel;

public class ThreadB extends Thread
{
	ThreadA a;
	public ThreadB(ThreadA a)
	{
		this.a = a;
	}
	@Override
	public void run()
	{
		System.out.println("B start");
		for(int i = 0; i < 10; ++i)
		{
			if(i== 2)
				a.yield();
			System.out.println(" b " + i);
		}
		System.out.println("B end");
	}
}
