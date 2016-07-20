package collection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableAndFuture
{
	private class MatchCounter implements Callable<Integer>
	{
		private File directory;
		private String keyword;
		private int count;
		
		public MatchCounter(File directory, String keyword)
		{
			this.directory = directory;
			this.keyword = keyword;
		}
		
		private boolean search(File file)
		{
			return false;
		}
		public Integer call() throws InterruptedException
		{
			count = 0;
			File[] files = directory.listFiles();
			List<Future<Integer>> results = new ArrayList<>();
			
			for(File file : files)
			{
				if(file.isDirectory())
				{
					MatchCounter counter = new MatchCounter(file, keyword);
					FutureTask<Integer> task = new FutureTask<Integer>(counter);
					results.add(task);
					Thread t = new Thread(task);
					t.start();
				}
				else
				{
					if(search(file))
						++count;
				}
			}
			
			for(Future<Integer> result : results)
			{
				try
				{
					count += result.get();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			return count;
		}
	}
}
