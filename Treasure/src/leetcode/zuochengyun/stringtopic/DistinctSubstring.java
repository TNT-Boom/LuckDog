package leetcode.zuochengyun.stringtopic;

import java.io.IOException;
import java.io.InputStream;

public class DistinctSubstring
{
	public static void main(String[] args) throws ClassNotFoundException
	{
		System.out.println(longestSubstring("limingjian",10));
		
		
		ClassLoader myLoader = new ClassLoader()
		{
			@Override
			public Class<?> loadClass(String name) throws ClassNotFoundException
			{
				try
				{
					String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
					InputStream is = getClass().getResourceAsStream(fileName);
					if(is == null)
					{
						return super.loadClass(name);
					}
					byte[] b = new byte[is.available()];
					is.read(b);
					return defineClass(name, b, 0, b.length);
				}
				catch(IOException e)
				{
					throw new ClassNotFoundException("name"); 
				}
			}
		};
		
		Object object = myLoader.loadClass("leetcode.zuochengyun.stringtopic.DistinctSubstring");
		System.out.println(object);
		System.out.println(object instanceof DistinctSubstring);
		Object sysCObject = ClassLoader.getSystemClassLoader().loadClass("leetcode.zuochengyun.stringtopic.DistinctSubstring");
		System.out.println(sysCObject.equals(object));
	}
	
	
	public static int longestSubstring(String A, int n)
	{
		 if (A == null || n == 0) {
	            return 0;
	        }
	        char[] chas = A.toCharArray();
	        int[] map = new int[256];
	        for (int i = 0; i < 256; i++) {
	            map[i] = -1;
	        }
	        int len = 0;
	        int pre = -1;
	        int cur = 0;
	        for (int i = 0; i < n; i++) {
	            pre = Math.max(pre, map[chas[i]]);
	            cur = i - pre;
	            len = Math.max(len, cur);
	            map[chas[i]] = i;
	        }
	        return len;
	}
}
