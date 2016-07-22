package com.limingjian.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleServer extends Thread
{
	private Socket client;

	public SimpleServer(Socket client)
	{
		System.out.println("Connected to client : " + client.getInetAddress());
		this.client = client;
	}

	@Override
	public void run()
	{
		try
		{
			BufferedReader in = new BufferedReader(
				new InputStreamReader(client.getInputStream()));
			BufferedReader serverIn = new BufferedReader(new InputStreamReader(System.in)); 
			PrintWriter toClient = new PrintWriter(client.getOutputStream());
			
			
			while(true)
			{
				String recvStr = in.readLine();
				System.out.println(recvStr);
				
				System.out.println("Wait input that wil be send to client...");
				toClient.println(serverIn.readLine());
				toClient.flush();
				
				if(recvStr != null && recvStr.equals("end"))
					break;
				
			}
			client.close();
		}
		catch (IOException e)
		{
			System.out.println("Client is reset...");
			try
			{
				client.close();
			}
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
