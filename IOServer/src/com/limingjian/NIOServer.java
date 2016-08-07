package com.limingjian;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOServer
{
	// 类似于C++中的selector
	private Selector selector;
	
	/**
	 * 获得一个ServerSocket通道，并对该通道做一些初始化工作
	 * 
	 * @param port
	 * @throws IOException
	 * @see [类、类#方法、类#成员]
	 */
	public void initServer(int port) throws IOException
	{
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		
		// 设置成非阻塞的
		serverSocketChannel.configureBlocking(false);
		serverSocketChannel.socket().bind(new InetSocketAddress(5555)); // 感觉特别类似C++中的注册文件描述符
		this.selector = Selector.open();
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT); // 类似select中设置某个事件文件描述符集合
	}
	
	/**
	 * 使用轮询方式检测selector上面是否有状态发生变化的socket
	 * <一句话功能简述>
	 * <功能详细描述>
	 * @throws IOException 
	 * @see [类、类#方法、类#成员]
	 */
	public void listen() throws IOException
	{
		System.out.println("服务器启动成功。。。");
		while(true)
		{
			selector.select();
			Iterator<?> its = selector.selectedKeys().iterator();
			while(its.hasNext())
			{
				SelectionKey key = (SelectionKey)(its.next());
				its.remove();
				handler(key);
			}
		}
	}
	
	private void handler(SelectionKey key) throws IOException
	{
		if(key.isAcceptable())
		{
			handleAcceptable(key);
		}
		else if(key.isReadable())
		{
			handleReadable(key);
		}
	}
	
	private void handleAcceptable(SelectionKey key) throws IOException
	{
		ServerSocketChannel serverSocketChannel = (ServerSocketChannel)key.channel();
		SocketChannel client = serverSocketChannel.accept(); // 就是C++封装库里面accept_timeout之后
		client.configureBlocking(false); // 设置成非阻塞
		System.out.println("Accept a client:" + client.getRemoteAddress());
		
		// 告诉seletor，要监听读事件。
		client.register(selector, SelectionKey.OP_READ);
	}
	
	private void handleReadable(SelectionKey key) throws IOException
	{
		SocketChannel client = (SocketChannel)key.channel(); // 发生变化的，这次取出来就是客户端
		System.out.println("Client state changed, Addr:" + client.getRemoteAddress());
		ByteBuffer buffer = ByteBuffer.allocate(10);

		int read = client.read(buffer);
		if (read > 0)
		{
			byte[] data = buffer.array();
			String msg = new String(data).trim();
			System.out.println("Recv: " + msg);
			
			ByteBuffer back = ByteBuffer.wrap("服务器回复".getBytes());
			client.write(back);
		}
		else
		{
			// 客户端发送数据完毕，并且关闭了socket
			System.out.println("Client closed, Addr: " + client.getRemoteAddress());
			key.cancel();
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		NIOServer server = new NIOServer();
		server.initServer(5555);
		server.listen(); // 采用while循环等待Socket发生变化
	}
}
