package collection;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class LinkedHashMapTest
{
	public void test()
	{
		LinkedHashMap<Object, Object> student = new LinkedHashMap<>();
		student.put("3", "ming");
		student.put("1", "hong");
		student.put("2", "hua");
		Iterator iterator = student.entrySet().iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}
	
	
}
