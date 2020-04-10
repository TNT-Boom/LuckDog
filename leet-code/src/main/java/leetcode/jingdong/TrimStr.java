package leetcode.jingdong;

public class TrimStr
{
	public static void main(String[] args)
	{
		String st = " i am a   little boy.  ";
		System.out.println(trimStr(st));
		char[] str = st.toCharArray();
		int i = 0, j = 0;
		while (str[i] == ' ')
		{
			i++;
		}
		while (i <= str.length - 1) // ����ÿ���ַ�
		{
			if (str[i] == ' ' && (i == str.length - 1 || str[i + 1] == ' ')) // ��β������һ���ַ���Ȼ�ǿո�
			{ // ����м�ո��֮�󻹴��ڿո�Ļ��������ǽ�β�Ļ���
				i++;
				continue;
			}
			str[j++] = str[i++]; // ��ǰ�ƶ�

		}
		for (int o = 0; o < j; o++)
		{
			System.out.print(str[o]);
		}
	}

	public static String trimStr(String str)
	{

		char[] source = str.toCharArray();
		int i = 0, j = 0;
		// i ����������һ��λ��
		// j ��ǰ����Ҫ�ƶ���λ��
		while (source[j] == ' ')
			j++;
		while (j < source.length)
		{
			// ���Ա�֤��һ���ո�,���Ҳ�����β�Ϳո��ж�����||����Ū��
			if (source[j] == ' ' && (j == source.length - 1 || source[j + 1] == ' ')) 
			{
				j++;
				continue;
			}
			source[i++] = source[j++];
		}
		StringBuilder builder = new StringBuilder();
		for (int k = 0; k < i; k++)
		{
			builder.append(source[k]);
		}
		return builder.toString();
	}
}
