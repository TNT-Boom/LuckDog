package com.limingjian.multinio;

import com.limingjian.multinio.pool.NioSelectorRunnablePool;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class MultiNioMain {
    public static void main(String[] args) {
        NioSelectorRunnablePool nioSelectorRunnablePool =
                new NioSelectorRunnablePool(Executors.newCachedThreadPool(), Executors.newCachedThreadPool());

        NioServerBootstrap nioServerBootstrap = new NioServerBootstrap(nioSelectorRunnablePool);

        nioServerBootstrap.bind(new InetSocketAddress(5555));

        System.out.println("Start...");
    }
}
