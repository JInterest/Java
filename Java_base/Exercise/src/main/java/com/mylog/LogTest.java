package com.mylog;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class LogTest {
    public static void main(String[] args) {
        Logger.log("第一次打开日志");
        Logger.log("第二次打开日志");
        Logger.log("第三次打开日志");
        System.out.println("输出到日志文件");

        //重新定位到标准输出流 System.setOut(System.out);
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        System.out.println("重新输出到控制台");
        Logger.log("第四次打开日志");

    }
}
