package com.limingjian.multinio.pool;

import java.nio.channels.SocketChannel;

public interface Worker
{
	/*
	 * �����µĿͻ��˻Ự
	 */
	public void registerNewClientChannel(SocketChannel channel);
}
