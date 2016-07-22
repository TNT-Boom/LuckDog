package com.limingjian.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleClient
{
	private Socket server;
	public SimpleClient()
	{
		
	}
	
	public void connectToServer()
	{
		try
		{
			server = new Socket(InetAddress.getLocalHost(), 5678);
			if(server.isConnected())
			{
				System.out.println("Server connected...");
			}
			else
			{
				return;
			}
			BufferedReader fromServer = new BufferedReader(new InputStreamReader(server.getInputStream()));
			PrintWriter toServer = new PrintWriter(server.getOutputStream());
			BufferedReader clientInReader = new BufferedReader(new InputStreamReader(System.in));
			while(true)
			{
				System.out.println("Wait input string that will be send to server...");
				String clientIn = clientInReader.readLine();
				toServer.println(clientIn);
				toServer.flush();
				if(clientIn.equals("end"))
				{
					break;
				}

				System.out.println("From Server : " + fromServer.readLine());
			}
			server.close();
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			System.out.print("Server is reset...");
			try
			{
				server.close();
			}
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
