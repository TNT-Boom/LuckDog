package leetcode.jingdong;

/*
 * �ŵڶ�ͷ���ظ���һ���̣����Ⱦ���n�ݣ��ӵ�һ��Ȼ������һ�ݣ��Դ�����ֱ�����һͷ�ܶ�������(���һͷ���ӵ����������0����Ҳ����n�ݾ���)����������ƻ�������ж��ٸ���
����һ������n,��ʾ�ܵĸ��������������ƻ��������֤�н⡣
����������
2
���أ�3
 */
public class Apples
{
	public int getInitial(int n)
	{
		if (n < 0)
			return 0;
		int total = 0; // �����ҵ�����
		while(true)
		{
			if(total >= Integer.MAX_VALUE)
				return 0;
			total++;
			int bearCount = n;
			while(bearCount > 0)
			{
				if((total - 1) % n == 0)
				{
					total = total -  total / n - 1;
					bearCount--;
				}
				else 
					break;
			}
			if(bearCount == 0)
				return total;
			
		}
	}
}
