package collection;

import java.util.ArrayList;
import java.util.List;

public class ListTest
{
	public void subList()
	{
		List<Integer> list = new ArrayList<Integer>(){{
			add(1);
			add(2);
			add(3);
			add(4);
			add(5);
			add(6);
		}};
		List<Integer> subList = list.subList(2, 5);
		subList.clear();
		System.out.println(list.size());
	}
}
