package com.limingjian.proxy.virtual;

/**
 * 虚拟代理，当耗时的对象没有准备好，提供代理的行为
 * Head First 设计模式 P464
 * @author limingjian
 * @date 2020/6/6
 *
 */
public class ImageProxy implements Icon {
    volatile ImageIcon imageIcon;
    volatile boolean init = false;

    @Override
    public void paintIcon() {
        if (imageIcon != null) {
            imageIcon.paintIcon();
            return;
        }

        System.out.println("Img is loading...");
        // TODO 应该加锁保证线程安全，但是不是此设计模式示例代码重点，不予讨论。
        if (!init) {
            new Thread(() -> {
                init = true;
                // 提供了实例化被代理对象的途径
                this.imageIcon = new ImageIcon();
                // 模拟耗时操作
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    @Override
    public int getIconWidth() {
        if (imageIcon != null) {
            return imageIcon.getIconWidth();
        }

        return 80;
    }

    @Override
    public int getIconHeight() {
        if (imageIcon != null) {
            return imageIcon.getIconHeight();
        }

        return 80;
    }
}