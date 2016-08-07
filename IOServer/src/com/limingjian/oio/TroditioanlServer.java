package com.limingjian.oio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TroditioanlServer
{
	public static void main(String[] args) throws IOException
	{
		ExecutorService executorService = Executors.newCachedThreadPool();
		@SuppressWarnings("resource")
		ServerSocket socket = new ServerSocket(5555);
		System.out.println("开始监听port 5555");
		final Socket client = socket.accept(); // 阻塞点
		
		executorService.execute(new Runnable()
		{
			
			@Override
			public void run()
			{
				handler(client);
				
			}
		});
		
	}
	
	private static void handler(Socket client)
	{
		byte[] bytes = new byte[1024];
		try
		{
			InputStream inputStream = client.getInputStream();
			while(true)
			{
				int read = inputStream.read(bytes); // 阻塞点
				if(read != -1)
				{
					System.out.println(new String(bytes, 0, read));	
				}
				else
				{
					break;
				}
			}
			
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
