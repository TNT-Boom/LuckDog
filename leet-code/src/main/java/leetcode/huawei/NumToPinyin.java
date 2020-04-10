package leetcode.huawei;

import java.util.Stack;

public class NumToPinyin
{
	public static void main(String[] args)
	{
		getPinyin(10301);
		getPinyin(10301);
		getPinyin(1010);
		getPinyin(103);
		getPinyin(100);
	}

	private static void getPinyin(int num)
	{
		String[] one = new String[] {"", "ʮ", "��", "ǧ"};
		String[] two = new String[] {"", "��", "��"};
		int currPos = 0;
		int oneIndex = 0;
		int twoIndex = 0;
		Stack<String> result = new Stack<>();
		do
		{
			if(oneIndex == 4)
			{
				result.push(two[twoIndex]);
				
			}
			oneIndex %= 4;
			twoIndex %= 3;
			
			if (num % 10 == 0)
			{
				if (currPos == 0) // ������һλ��0���򲻶�
				{
					
				}
				
				// �����ǰ== 0��ǰһ��ҲΪ0���Ҳ����� ����ѹ��0
				else if(result.isEmpty() || result.peek().equals("0"))
				{
					
				}
				else 
				{
					result.push(num % 10 + "");
				}
				num /= 10;
				++currPos;
				++oneIndex;
				if (oneIndex == 4)
				{
					++twoIndex;
				}
				continue;
			}
			
			result.push(one[oneIndex] + "");
			result.push(num % 10 + "");
			currPos++;
			++oneIndex;
			if (oneIndex == 4)
			{
				++twoIndex;
			}
			num /= 10;
			

		} while (num != 0);
		
		StringBuilder builder = new StringBuilder();
		while(!result.isEmpty())
		{
			builder.append(result.pop());
		}
		System.out.println(builder.toString());
	}
}
