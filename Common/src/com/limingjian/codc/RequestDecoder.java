package com.limingjian.codc;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;

import com.limingjian.global.ConstantValue;
import com.limingjian.model.Request;

public class RequestDecoder extends FrameDecoder // FrameDecoder����Э�����ǽ��ճ���ְ�����
{

	@Override
	protected Object decode(ChannelHandlerContext ctx, Channel channel, ChannelBuffer buffer)
		throws Exception
	{
		if (buffer.readableBytes() >= ConstantValue.BASE_LENTH) // ���ȱ�����ڻ�������
		{
			int readerIndex = buffer.readerIndex(); // ��¼��ͷ��ʼ�Ķ�ָ��λ��

			Request request = new Request();
			while (true) // һֱ�Ұ�ͷ
			{
				if (buffer.readInt() == ConstantValue.FLAG)
				{
					break;
				}
			}

			short moudle = buffer.readShort();
			short cmd = buffer.readShort();
			int dataLen = buffer.readInt();
			// �п������ݲ�ȫ

			if (buffer.readableBytes() < dataLen) // ��ʱ�Ѿ���ȡ�ˣ�Ȼ����û���õ���������Ҫ��ԭBUFFER
			{
				buffer.readerIndex(readerIndex);
				return null; // �ȴ����ݰ�
			}

			byte[] data = new byte[dataLen];
			buffer.readBytes(data);
			request.setModule(moudle);
			request.setCmd(cmd);
			request.setData(data);
			
			// �������´��ݣ���ʵ���յ��õ���sendUpStream
			return request;
		}

		// ���ݰ�������
		return null; // ��ʾ�ȴ����ݰ�
	}

}
