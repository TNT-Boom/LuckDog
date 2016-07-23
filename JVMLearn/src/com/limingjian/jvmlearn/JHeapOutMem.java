package com.limingjian.jvmlearn;

import java.util.ArrayList;
import java.util.List;

public class JHeapOutMem
{
	/*
	 * ²âÊÔ¶ÑÒç³ö£¬JVM²ÎÊý£º
	 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
	 */
	static class OOMObject
	{}
	private static List<OOMObject> list = new ArrayList<>();
	
	public static void OutOfMem()
	{
		while(true)
		{
			list.add(new OOMObject());
		}
	}
}
