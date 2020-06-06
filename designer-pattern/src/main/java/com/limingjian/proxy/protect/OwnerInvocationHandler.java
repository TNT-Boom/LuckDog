package com.limingjian.proxy.protect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * �����ӽǵĶ�̬��������һЩ����Ȩ��
 * @author limingjian
 * @date 2020/6/6
 *
 */
public class OwnerInvocationHandler implements InvocationHandler {
    IPersonBean personBean;

    public OwnerInvocationHandler(IPersonBean personBean) {
        this.personBean = personBean;
    }

    /**
     * Proxy���յ�ʵ�ֻὫ����ת����invoke����
     * �����û����ܸ����Լ��ķ���
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws IllegalAccessException
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
        try{
            if(method.getName().startsWith("get")){
                return method.invoke(personBean, args);
            }

            if(method.getName().equals("setHotOrNotRating")) {
                throw new IllegalAccessException("user can not change self HotOrNatRating");
            }

            if(method.getName().startsWith("set")){
                return method.invoke(personBean, args);
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}