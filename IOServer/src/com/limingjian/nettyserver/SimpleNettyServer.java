package com.limingjian.nettyserver;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.Bootstrap;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

public class SimpleNettyServer
{
	public static void main(String[] args)
	{
		ServerBootstrap serverBootstrap = new ServerBootstrap();
		
		// boss���������worker�����д
		ExecutorService boss = Executors.newCachedThreadPool();
		ExecutorService worker = Executors.newCachedThreadPool();
		
		// ���ù���
		serverBootstrap.setFactory(new NioServerSocketChannelFactory(boss, worker));
		
		// ���ùܵ�������
		serverBootstrap.setPipelineFactory(new ChannelPipelineFactory()
		{
			
			@Override
			public ChannelPipeline getPipeline()
				throws Exception
			{
				ChannelPipeline pipeline = Channels.pipeline();
				pipeline.addLast("decoder", new StringDecoder()); // ����
				pipeline.addLast("encoder", new StringEncoder()); //����
				pipeline.addLast("helloHandler", new HelloHandler());
				return pipeline;
			}
		});
		
		serverBootstrap.bind(new InetSocketAddress(5555));
	}
}
