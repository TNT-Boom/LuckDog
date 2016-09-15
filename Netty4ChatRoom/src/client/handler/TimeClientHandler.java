package client.handler;

import java.util.Date;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TimeClientHandler extends ChannelInboundHandlerAdapter
{
	private ByteBuf buffer;
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
		throws Exception
	{
		ByteBuf m = (ByteBuf)msg; // (1)
			
			buffer.writeBytes(m);
			m.release();
			if(buffer.readableBytes() >= 4)
			{
				long currentTimeMillis = (m.readUnsignedInt() - 2208988800L) * 1000L;
				System.out.println(new Date(currentTimeMillis));
				ctx.close();
			}
			
	}
	
	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception
	 {
		buffer = ctx.alloc().buffer(4);
	 }
	
	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception
	{
		buffer.release();
		buffer = null;
	}

}
