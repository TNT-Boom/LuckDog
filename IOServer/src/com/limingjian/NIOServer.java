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
	// ������C++�е�selector
	private Selector selector;
	
	/**
	 * ���һ��ServerSocketͨ�������Ը�ͨ����һЩ��ʼ������
	 * 
	 * @param port
	 * @throws IOException
	 * @see [�ࡢ��#��������#��Ա]
	 */
	public void initServer(int port) throws IOException
	{
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		
		// ���óɷ�������
		serverSocketChannel.configureBlocking(false);
		serverSocketChannel.socket().bind(new InetSocketAddress(5555)); // �о��ر�����C++�е�ע���ļ�������
		this.selector = Selector.open();
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT); // ����select������ĳ���¼��ļ�����������
	}
	
	/**
	 * ʹ����ѯ��ʽ���selector�����Ƿ���״̬�����仯��socket
	 * <һ�仰���ܼ���>
	 * <������ϸ����>
	 * @throws IOException 
	 * @see [�ࡢ��#��������#��Ա]
	 */
	public void listen() throws IOException
	{
		System.out.println("�����������ɹ�������");
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
		SocketChannel client = serverSocketChannel.accept(); // ����C++��װ������accept_timeout֮��
		client.configureBlocking(false); // ���óɷ�����
		System.out.println("Accept a client:" + client.getRemoteAddress());
		
		// ����seletor��Ҫ�������¼���
		client.register(selector, SelectionKey.OP_READ);
	}
	
	private void handleReadable(SelectionKey key) throws IOException
	{
		SocketChannel client = (SocketChannel)key.channel(); // �����仯�ģ����ȡ�������ǿͻ���
		System.out.println("Client state changed, Addr:" + client.getRemoteAddress());
		ByteBuffer buffer = ByteBuffer.allocate(10);

		int read = client.read(buffer);
		if (read > 0)
		{
			byte[] data = buffer.array();
			String msg = new String(data).trim();
			System.out.println("Recv: " + msg);
			
			ByteBuffer back = ByteBuffer.wrap("�������ظ�".getBytes());
			client.write(back);
		}
		else
		{
			// �ͻ��˷���������ϣ����ҹر���socket
			System.out.println("Client closed, Addr: " + client.getRemoteAddress());
			key.cancel();
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		NIOServer server = new NIOServer();
		server.initServer(5555);
		server.listen(); // ����whileѭ���ȴ�Socket�����仯
	}
}
