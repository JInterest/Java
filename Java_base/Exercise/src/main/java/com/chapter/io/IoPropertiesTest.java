package com.chapter.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/*
IO+Properties的联合应用。
非常好的一个设计理念：
    以后经常改变的数据，可以单独写到一个文件中，使用程序动态读取。
    将来只需要修改这个文件的内容，java代码不需要改动，不需要重新
    编译，服务器也不需要重启，就可以拿到动态信息。

    类似以上机制的这种文件被称为配置文件。
    并且当配置文件中的内容格式是：
        key1=value
        key2=value
     的时候，我们把这种配置文件称为属性配置文件。

     java规范中有要求：属性配置文件建议以.properties结尾，但这不是必须的。
     其中properties是专门存放属性配置文件内容的一个类。
 */

public  class IoPropertiesTest {
    public static void main(String[] args) {
        FileInputStream fis=null;
        try {
            fis=new FileInputStream("UserInfo.properties");

            Properties pro=new Properties();
            //用properties对象的load方法将数据加载到map集合中
            //pro.load(字节流对象/字符流对象)；文件中数据顺着管道加载到map集合中，其实左边为key，右边为value
            pro.load(fis);
            String name=pro.getProperty("name");
            System.out.println(name);
            String id=pro.getProperty("id");
            System.out.println(id);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis!= null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
