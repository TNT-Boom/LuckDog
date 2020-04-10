package com.limingjian.multinio.pool;

import java.nio.channels.SocketChannel;

public interface Worker {
    /*
     * 加入新的客户端会话
     */
    public void registerNewClientChannel(SocketChannel channel);
}
