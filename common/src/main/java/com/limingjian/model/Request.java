package com.limingjian.model;

/*
 * �������
 */
public class Request {
    /*
     * ����ģ��
     */
    private short module;

    /*
     * ģ��֮��������
     */
    private short cmd;

    /*
     * ���ݲ���
     */
    private byte[] data;

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public short getCmd() {
        return cmd;
    }

    public void setCmd(short cmd) {
        this.cmd = cmd;
    }

    public short getModule() {
        return module;
    }

    public void setModule(short module) {
        this.module = module;
    }

    public int getDataLen() {
        if (data != null) {
            return data.length;
        } else {
            return 0;
        }
    }
}
