package com.limingjian.proxy.protect;

import java.lang.reflect.Proxy;

/**
 * @author limingjian
 * @date 2020/6/6
 *
 */
public class Main {
    public static void main(String[] args) {
        PersonBean personBean = new PersonBean();
        IPersonBean ownerProxy = getOwnerProxy(personBean);
        ownerProxy.setHotOrNotRating(1);
    }


    public static IPersonBean getOwnerProxy(IPersonBean personBean) {
        return (IPersonBean) Proxy.newProxyInstance(personBean.getClass().getClassLoader(),
                personBean.getClass().getInterfaces(),
                new OwnerInvocationHandler(personBean));
    }

    public static IPersonBean getNoOwnerProxy(IPersonBean personBean){
        return (IPersonBean) Proxy.newProxyInstance(personBean.getClass().getClassLoader(),
                personBean.getClass().getInterfaces(),
                new NonOwnerInvocationHandler(personBean));
    }
}