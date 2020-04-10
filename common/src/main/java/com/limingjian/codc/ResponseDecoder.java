package com.limingjian.codc;

import com.limingjian.global.ConstantValue;
import com.limingjian.model.Response;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;

/*
 * respnse ������
 */
public class ResponseDecoder extends FrameDecoder {
    @Override
    protected Object decode(ChannelHandlerContext ctx, Channel channel, ChannelBuffer buffer)
            throws Exception {
        if (buffer.readableBytes() >= ConstantValue.BASE_LENTH) // ���ȱ�����ڻ�������
        {
            int readerIndex = buffer.readerIndex(); // ��¼��ͷ��ʼ�Ķ�ָ��λ��

            Response response = new Response();
            while (true) // һֱ�Ұ�ͷ
            {
                if (buffer.readInt() == ConstantValue.FLAG) {
                    break;
                }
            }

            short moudle = buffer.readShort();
            short cmd = buffer.readShort();
            int stateCode = buffer.readInt();
            int dataLen = buffer.readInt();
            // �п������ݲ�ȫ

            if (buffer.readableBytes() < dataLen) // ��ʱ�Ѿ���ȡ�ˣ�Ȼ����û���õ���������Ҫ��ԭBUFFER
            {
                buffer.readerIndex(readerIndex);
                return null; // �ȴ����ݰ�
            }

            byte[] data = new byte[dataLen];
            buffer.readBytes(data);
            response.setModule(moudle);
            response.setCmd(cmd);
            response.setData(data);
            response.setStateCode(stateCode);
            // �������´��ݣ���ʵ���յ��õ���sendUpStream
            return response;
        }

        // ���ݰ�������
        return null; // ��ʾ�ȴ����ݰ�
    }

}
