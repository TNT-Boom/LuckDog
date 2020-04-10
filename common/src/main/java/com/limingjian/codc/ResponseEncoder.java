package com.limingjian.codc;

import com.limingjian.global.ConstantValue;
import com.limingjian.model.Response;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

/*
 * 包头， 模块号，命令号，状态码，长度，数据
 */
public class ResponseEncoder extends OneToOneEncoder {
    @Override
    protected Object encode(ChannelHandlerContext ctx, Channel channel, Object msg)
            throws Exception {
        Response response = (Response) msg;

        ChannelBuffer buffer = ChannelBuffers.dynamicBuffer();

        buffer.writeByte(ConstantValue.FLAG);
        buffer.writeShort(response.getModule());
        buffer.writeShort(response.getCmd());
        buffer.writeInt(response.getStateCode());
        buffer.writeInt(response.getDataLen());
        buffer.writeBytes(response.getData());
        return buffer;
    }
}
