package server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class ServerMain
{
	public static void main(String[] args)
	{
		ServerBootstrap serverBootstrap = new ServerBootstrap();
		EventLoopGroup boss = new NioEventLoopGroup();
		EventLoopGroup worker = new NioEventLoopGroup();
		try
		{
			serverBootstrap.group(boss, worker); // ���ü����̣߳����ݴ����߳�

			serverBootstrap.channel(NioServerSocketChannel.class);

			serverBootstrap.childHandler(new MyChannelInitializer());

			serverBootstrap.option(ChannelOption.SO_BACKLOG, 2048); // �ײ�IOListen�Ķ�����
			serverBootstrap.option(ChannelOption.SO_KEEPALIVE, true); // ���������
			serverBootstrap.option(ChannelOption.TCP_NODELAY, true); // ȡ���ӳٷ���
			ChannelFuture future = serverBootstrap.bind(5555);
			System.out.println("ChatRoom Server Start..." + System.currentTimeMillis());

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
