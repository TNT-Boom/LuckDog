package com.limingjian.proxy.protect;

/**
 * һ�������ṹ������ͱ�����Ķ���ʵ������ӿ�
 * �����û��Լ������������Լ������֣������˲������ñ��˵���Ȥ
 * ����ʵ��������̬����һ����ʹ���߱��˵��ӽǣ�һ���������ӽ�
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
