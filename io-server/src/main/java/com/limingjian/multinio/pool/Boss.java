package com.limingjian.multinio.pool;

import java.nio.channels.ServerSocketChannel;

public interface Boss
{
	/**
	 * ����һ���µ�ServerSocket
	 */
	public void registerAcceptChannelTask(ServerSocketChannel serverChannel);
}
