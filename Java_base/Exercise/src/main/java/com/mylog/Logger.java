package com.mylog;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    /*
     记录日志的方法
    */
    public static void log(String msg) {
        try {
            //标准输出流 设置输出到mylog。txt文件
            PrintStream pr=new PrintStream(new FileOutputStream("mylog.txt",true));
            System.setOut(pr);

            //获取当前时间
            Date nowTime =new Date();
            //格式化时间
            SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd  HH:mm:sss SSS");
            String strTime=sdf.format(nowTime);
            System.out.println(strTime+":"+msg);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
