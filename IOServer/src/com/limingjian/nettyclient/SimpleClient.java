package com.limingjian.nettyclient;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.ChannelSink;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

public class SimpleClient
{
	public static void main(String[] args)
	{
		ClientBootstrap clientBootstrap = new ClientBootstrap();
		
		// 同样需要两个线程池
		ExecutorService boss = Executors.newCachedThreadPool();
		ExecutorService worker = Executors.newCachedThreadPool();
		
		clientBootstrap.setFactory(new NioClientSocketChannelFactory(boss, worker));
		
		clientBootstrap.setPipelineFactory(new ChannelPipelineFactory()
		{
			
			@Override
			public ChannelPipeline getPipeline()
				throws Exception
			{
				ChannelPipeline pipeline = Channels.pipeline();
				pipeline.addLast("decoder", new StringDecoder()); // 上行
				pipeline.addLast("encoder", new StringEncoder()); //下行
				pipeline.addLast("hiHandler", new HiHandler());
				return pipeline;
			}
		});
		
		ChannelFuture connect = clientBootstrap.connect(new InetSocketAddress("127.0.0.1", 5555));
		Channel channel = connect.getChannel(); // 其实这与Connect函数里的一样，同一个会话
		
		System.out.println("Client begin...");
		while(true)
		{
			System.out.println("Please input...");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			try
			{
				channel.write(reader.readLine());
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
