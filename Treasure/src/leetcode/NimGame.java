package leetcode;

import base.BaseAlgorithm;

public class NimGame implements BaseAlgorithm
{
	
	@Override
	public void runDemo()
	{
		System.out.println(canWinNim(100));
	}
	/*A �ȣ� B ��
	 * ���ȿ������ֱ���
	 * ����m + 1 ����������A�����������ǵ�B����ȡ��ʣ�µġ�
	 * ����(m + 1 )k������A��һ�������������ǵ�B������� (m + 1)(k -1)�������Ȼ���ֵ�A
	 * ��������������ܵ�m + 1�������A���������գ�A����
	 *
	 * ���濼�Ǳ�Ӯ
	 * ����(m + 1)k + s �������� 0 < s <= m
	 * A����1����Ȼ����� (m + 1)(k - 1) + m + s�������B
	 * �ֵ�B������B��������A�������(m + 1)(k - 2) + m + s�������B
	 * ��������������� m + s ��B��������B��ʲô��A���� Ӯ��
	 */
	public boolean canWinNim(int n)
	{
		return n % (3 + 1) != 0;
	}
}
