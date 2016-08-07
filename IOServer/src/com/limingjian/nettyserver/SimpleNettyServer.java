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
		
		// boss负责监听，worker负责读写
		ExecutorService boss = Executors.newCachedThreadPool();
		ExecutorService worker = Executors.newCachedThreadPool();
		
		// 设置工厂
		serverBootstrap.setFactory(new NioServerSocketChannelFactory(boss, worker));
		
		// 设置管道过滤器
		serverBootstrap.setPipelineFactory(new ChannelPipelineFactory()
		{
			
			@Override
			public ChannelPipeline getPipeline()
				throws Exception
			{
				ChannelPipeline pipeline = Channels.pipeline();
				pipeline.addLast("decoder", new StringDecoder()); // 上行
				pipeline.addLast("encoder", new StringEncoder()); //下行
				pipeline.addLast("helloHandler", new HelloHandler());
				return pipeline;
			}
		});
		
		serverBootstrap.bind(new InetSocketAddress(5555));
	}
}
