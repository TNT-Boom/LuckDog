package com.limingjian.multinio;

import com.limingjian.multinio.pool.Boss;
import com.limingjian.multinio.pool.NioSelectorRunnablePool;
import com.limingjian.multinio.pool.Worker;

import java.io.IOException;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

public class NioServerBoss extends AbstractNioSelector implements Boss {

    public NioServerBoss(Executor boss, String threadName, NioSelectorRunnablePool pool) {
        super(boss, threadName, pool);
    }

    @Override
    public void registerAcceptChannelTask(final ServerSocketChannel serverChannel) {
        final Selector selector = this.selector; // 父类的selector
        registerTask(new Runnable() {

            @Override
            public void run() {
                try {
                    serverChannel.register(selector, SelectionKey.OP_ACCEPT);
                } catch (ClosedChannelException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    @Override
    protected int select(Selector selector)
            throws IOException {
        return selector.select();
    }

    // 实际执行逻辑的部分，此时对应线程的Selector已经返回
    @Override
    protected void process(Selector selector)
            throws IOException {
        Set<SelectionKey> selectionKeys = selector.selectedKeys();
        if (selectionKeys.isEmpty()) {
            return;
        }

        for (Iterator<SelectionKey> it = selectionKeys.iterator(); it.hasNext(); ) {
            SelectionKey key = it.next();
            it.remove(); // 防止重复处理
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();

            //获取客户端连接
            SocketChannel clientChannel = serverSocketChannel.accept(); // 此时肯定不会阻塞，因为底层已经返回
            clientChannel.configureBlocking(false);

            Worker nextWorker = getNioSelectorRunnablePool().nextWorker();
            nextWorker.registerNewClientChannel(clientChannel);

            System.out.println("收到新客户端连接");
        }

    }

}
