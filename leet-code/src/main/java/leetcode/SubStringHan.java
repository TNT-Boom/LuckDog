package leetcode;

import base.BaseAlgorithm;

import java.io.UnsupportedEncodingException;

// 截取子字符串
public class SubStringHan implements BaseAlgorithm {
    @Override
    public void runDemo() {
        String string = "李hao好学习";
        try {
            System.out.println(cutString(string, 3));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private boolean isChineseChar(char c) throws UnsupportedEncodingException {
        return String.valueOf(c).getBytes("GBK").length > 1;
    }

    public String cutString(String source, int count) throws UnsupportedEncodingException {
        if (source != null && !"".equals(source)) {
            source = new String(source.getBytes(), "GBK");
            if (count > 0 && count < source.getBytes("GBK").length) {
                StringBuffer buffer = new StringBuffer();
                char c;
                for (int i = 0; i <= count - 1; i++) {
                    c = source.charAt(i);
                    buffer.append(c);
                    if (isChineseChar(c)) {
                        --count;
                    }
                }
                return buffer.toString();
            }
        }
        return source;
    }
}
