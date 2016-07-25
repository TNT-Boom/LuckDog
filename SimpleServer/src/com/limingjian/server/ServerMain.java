package com.limingjian.server;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerMain
{

	public static void main(String[] args)
	{
		try
		{
			ServerSocket serverSocket = new ServerSocket(5678);
			while(true)
			{
				System.out.println("Server start, listening...");
				SimpleServer simpleServer = new SimpleServer(serverSocket.accept());
				simpleServer.start();
			}
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
