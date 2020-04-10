package com.limingjian.model;

/*
 * 返回对象
 */
public class Response {
    /*
     * 请求模块
     */
    private short module;

    /*
     * 模块之外的命令号
     */
    private short cmd;

    /*
     * 状态码
     */
    private int stateCode;

    /*
     * 数据部分
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
