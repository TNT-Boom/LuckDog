package server.handler;

import java.text.SimpleDateFormat;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TimeHandler extends ChannelInboundHandlerAdapter
{
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
		throws Exception
	{
		cause.printStackTrace();
		// TODO Auto-generated method stub
		System.out.println("Get exception, closed...");
		ctx.close();
	}

	@Override
	public void channelActive(final ChannelHandlerContext ctx)
		throws Exception
	{
		ByteBuf time = ctx.alloc().buffer(4);
		time.writeInt((int)(System.currentTimeMillis() / 1000L - 2208988800L));
		
		final ChannelFuture f = ctx.writeAndFlush(time);
		f.addListener(new ChannelFutureListener()
		{
			
			@Override
			public void operationComplete(ChannelFuture future)
				throws Exception
			{
				assert f == future;
				ctx.close();
				
			}
		});
		
	}


}
