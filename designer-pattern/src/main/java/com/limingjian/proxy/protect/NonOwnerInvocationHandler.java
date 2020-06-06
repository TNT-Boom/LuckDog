package com.limingjian.proxy.protect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author limingjian
 * @date 2020/6/6
 *
 */
public class NonOwnerInvocationHandler implements InvocationHandler {
    IPersonBean personBean;

    public NonOwnerInvocationHandler(IPersonBean personBean) {
        this.personBean = personBean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
        try {
            if (method.getName().startsWith("get")) {
                return method.invoke(personBean, args);
            }
            if (method.getName().startsWith("set") && !method.getName().equals("setHotOrNotRating")) {
                throw new IllegalAccessException("others can not change any attribute except setHotOrNotRating");
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}