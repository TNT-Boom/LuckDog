package classloadertest;

public class SubClass extends SuperClass
{
	/*
	 * main���� SubClass.value���ڱ������ã���˸����಻�ᱻ��ʼ��
	 */
	static
	{
		System.out.println("SubClass init");
	}
}
