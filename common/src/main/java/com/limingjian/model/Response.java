package com.limingjian.model;

/*
 * ���ض���
 */
public class Response {
    /*
     * ����ģ��
     */
    private short module;

    /*
     * ģ��֮��������
     */
    private short cmd;

    /*
     * ״̬��
     */
    private int stateCode;

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

    public int getStateCode() {
        return stateCode;
    }

    public void setStateCode(int stateCode) {
        this.stateCode = stateCode;
    }
}
