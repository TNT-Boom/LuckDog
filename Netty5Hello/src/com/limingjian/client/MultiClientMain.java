package com.limingjian.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiClientMain
{
	public static void main(String[] args)
	{
		MultiClient multiClient = new MultiClient();
		multiClient.init(5);
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		while (true)
		{

			System.out.println("Please in put...");
			String msg;
			try
			{
				msg = bufferedReader.readLine();
				multiClient.nextChannel().writeAndFlush(msg);
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
	}
}
