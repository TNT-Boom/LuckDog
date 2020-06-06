package com.limingjian.proxy.protect;

/**
 * 一个基本结构，代理和被代理的对象实现这个接口
 * 但是用户自己，不能设置自己的评分，其他人不能设置别人的兴趣
 * 所以实现两个动态代理，一个是使用者本人的视角，一个是他人视角
 * @author lmj
 * @since 2020/6/6
 **/
public interface IPersonBean {
     String getName();
     String getGender();
     String getInterests();
     int getHotorNotRating();

     void setName(String name);
     void setGender(String gender);
     void setInterests(String interests);
     void setHotOrNotRating(int rating);
}
