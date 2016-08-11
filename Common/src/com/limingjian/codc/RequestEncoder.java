package com.limingjian.codc;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

import com.limingjian.global.ConstantValue;
import com.limingjian.model.Request;

/*
 * ÇëÇó±àÂëÆ÷
 */
public class RequestEncoder extends OneToOneEncoder
{

	@Override
	protected Object encode(ChannelHandlerContext ctx, Channel channel, Object msg)
		throws Exception
	{
		Request request = (Request)msg;
		
		ChannelBuffer buffer = ChannelBuffers.dynamicBuffer();
		
		buffer.writeByte(ConstantValue.FLAG);
		buffer.writeShort(request.getModule());
		buffer.writeShort(request.getCmd());
		
		buffer.writeInt(request.getDataLen());
		buffer.writeBytes(request.getData());
		return buffer;
		
	}

}
