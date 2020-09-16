package com.homework.Gather.four;

import java.util.Map;
import java.util.Properties;
import java.util.Set;
/*
* 有2个数组，第一个数组内容为：[黑龙江省,浙江省,江西省,广东省,福建省]，
第二个数组为：[哈尔滨,杭州,南昌,广州,福州]，
将第一个数组元素作为key，第二个数组元素作为value存储到Map集合中。
如{黑龙江省=哈尔滨, 浙江省=杭州, …}
* */
public class MapTest02 {
    public static void main(String[] args) {
        String[] p=new String[]{"黑龙江省","浙江省","江西省","广东省","福建省"};
        String[] c=new String[]{"哈尔滨","杭州","南昌","广州","福州"};

        Properties pro=new Properties();
        for (int i = 0; i <p.length ; i++) {
            pro.setProperty(p[i],c[i]);
        }
        Set<Map.Entry<Object, Object>> s=pro.entrySet();
        for (Map.Entry data:s
             ) {
            System.out.println(data);
        }
    }
}
