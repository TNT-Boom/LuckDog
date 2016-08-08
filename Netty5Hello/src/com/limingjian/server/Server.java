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
			// 设置线程池
			serverBootstrap.group(boss, worker);

			// 类似设置socket工厂
			serverBootstrap.channel(NioServerSocketChannel.class);

			serverBootstrap.childHandler(new MyChannelInitializer());

			serverBootstrap.option(ChannelOption.SO_BACKLOG, 2048); // 底层IOListen的队列数，
			serverBootstrap.childOption(ChannelOption.SO_KEEPALIVE, true); // 清除死链接
			serverBootstrap.childOption(ChannelOption.TCP_NODELAY, true); // 取消延迟发送

			ChannelFuture future = serverBootstrap.bind(5555);
			System.out.println("Start...");

			// 等待服务端关闭
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
