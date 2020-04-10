package com.limingjian.codc;

import com.limingjian.global.ConstantValue;
import com.limingjian.model.Response;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;

/*
 * respnse 解码器
 */
public class ResponseDecoder extends FrameDecoder {
    @Override
    protected Object decode(ChannelHandlerContext ctx, Channel channel, ChannelBuffer buffer)
            throws Exception {
        if (buffer.readableBytes() >= ConstantValue.BASE_LENTH) // 长度必须大于基本长度
        {
            int readerIndex = buffer.readerIndex(); // 记录包头开始的读指针位置

            Response response = new Response();
            while (true) // 一直找包头
            {
                if (buffer.readInt() == ConstantValue.FLAG) {
                    break;
                }
            }

            short moudle = buffer.readShort();
            short cmd = buffer.readShort();
            int stateCode = buffer.readInt();
            int dataLen = buffer.readInt();
            // 有可能数据不全

            if (buffer.readableBytes() < dataLen) // 此时已经读取了，然而又没有用到，所以需要还原BUFFER
            {
                buffer.readerIndex(readerIndex);
                return null; // 等待数据包
            }

            byte[] data = new byte[dataLen];
            buffer.readBytes(data);
            response.setModule(moudle);
            response.setCmd(cmd);
            response.setData(data);
            response.setStateCode(stateCode);
            // 继续往下传递，其实最终调用的是sendUpStream
            return response;
        }

        // 数据包不完整
        return null; // 表示等待数据包
    }

}
