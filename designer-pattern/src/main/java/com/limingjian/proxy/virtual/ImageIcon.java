package com.limingjian.proxy.virtual;

import java.awt.*;

/**
 * @author limingjian
 * @date 2020/6/6
 *
 */
public class ImageIcon implements Icon {
    @Override
    public void paintIcon() {
        System.out.println("output real image...");
    }

    @Override
    public int getIconWidth() {
        return 123;
    }

    @Override
    public int getIconHeight() {
        return 456;
    }
}