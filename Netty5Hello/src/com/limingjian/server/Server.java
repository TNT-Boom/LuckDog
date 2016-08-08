package com.limingjian.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Server
{
	public static void main(String[] args)
	{
		ServerBootstrap serverBootstrap = new ServerBootstrap();
		EventLoopGroup boss = new NioEventLoopGroup();
		EventLoopGroup worker = new NioEventLoopGroup();

		try
		{
			// �����̳߳�
			serverBootstrap.group(boss, worker);

			// ��������socket����
			serverBootstrap.channel(NioServerSocketChannel.class);

			serverBootstrap.childHandler(new MyChannelInitializer());

			serverBootstrap.option(ChannelOption.SO_BACKLOG, 2048); // �ײ�IOListen�Ķ�������
			serverBootstrap.childOption(ChannelOption.SO_KEEPALIVE, true); // ���������
			serverBootstrap.childOption(ChannelOption.TCP_NODELAY, true); // ȡ���ӳٷ���

			ChannelFuture future = serverBootstrap.bind(5555);
			System.out.println("Start...");

			// �ȴ�����˹ر�
			future.channel().closeFuture().sync();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			boss.shutdownGracefully();
			worker.shutdownGracefully();
		}
	}
}
