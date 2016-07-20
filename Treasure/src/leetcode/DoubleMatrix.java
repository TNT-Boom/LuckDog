package leetcode;

import base.BaseAlgorithm;

public class DoubleMatrix implements BaseAlgorithm
{
	@Override
	public void runDemo()
	{
		char[][] testChars = new char[][]
			{
			{'1','0','1','0','1'},
			{'1','1','1','0','1'},
			{'1','1','1','1','1'},
			{'1','0','1','0','0'}
		};
		System.out.println("input :");
		for (char[] cs : testChars)
		{
			for (char c : cs)
			{
				System.out.print(c + " ");	
			}
			System.out.println();	
		}
		System.out.println("max size : " + maximalSquare(testChars));
	}
	
	private int maximalSquare(char[][] matrix)
	{
		int maxSquare = 0;
		for(int lineIndex = 0; lineIndex < matrix.length; ++lineIndex)
		{
			char[] eachLine = matrix[lineIndex];
			for(int colIndex = 0; colIndex < eachLine.length; ++colIndex)
			{
				int currSquare = 0;
				if(eachLine[colIndex] == '1')
				{
					int tempLine = lineIndex;
					int tempColIndex = colIndex;
					currSquare = 1;
					while(expandNext(matrix, tempLine++, tempColIndex++, lineIndex, colIndex))
						++currSquare;
					 maxSquare = maxSquare > currSquare ? maxSquare : currSquare;
				}
			}
		}
		return maxSquare * maxSquare;
	}
	
	private boolean expandNext(char[][] matrix, int i, int j, int begini,int beginj)
	{
		if(i == matrix.length - 1 || j == matrix[i].length - 1)
			return false;
		int line = begini, col = beginj;
		++i;
		++j;
		
		while(line <= i)
		{
			if(matrix[line][j] != '1')
				return false;
			++line;
		}
		
		while(col < j)
		{
			if(matrix[i][col] != '1')
				return false;
			++col;
		}
		return true;
	}
}
