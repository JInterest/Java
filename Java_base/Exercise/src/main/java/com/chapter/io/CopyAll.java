package com.chapter.io;

import java.io.*;

public class CopyAll {
    public static void main(String[] args) {
//        拷贝源目录
        File srcFile=new File("D:\\AAA");
//        目标目录
        File destFile=new File("E:\\");
//        拷贝方法
        copyDir(srcFile,destFile);
    }

    private static void copyDir(File srcFile, File destFile) {
        if (srcFile.isFile()){
            FileInputStream fis=null;
            FileOutputStream fos=null;
            //获取目标路径
            String path=(destFile.getAbsolutePath().endsWith("\\")?destFile.getAbsolutePath():destFile.getAbsolutePath()+"\\")+srcFile.getAbsolutePath().substring(3);

            try {
                fis=new FileInputStream(srcFile);
                fos=new FileOutputStream(path);
                //一边读一边写
                byte[] bytes=new byte[1024*1024];//每次copy 1Mb
                int count=0;
                while((count=fis.read(bytes))!=-1){
                    fos.write(bytes,0,count);//读到多少写多少
                }
                //刷新此输出流并强制写出所有缓冲的输出字节。
                fos.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return;
        }
        //返回某个目录下所有文件和目录的绝对路径，返回的是File数组
        File[] files=srcFile.listFiles();
        for (File file:files
             ) {
            if (file.isDirectory()){
                //获取目录
                String srcDir=file.getAbsolutePath();
                //获取copy目标
                String destDir=(destFile.getAbsolutePath().endsWith("\\")?destFile.getAbsolutePath():destFile.getAbsolutePath()+"\\")+srcDir.substring(3);
                File newFile=new File(destDir);
                if ( !newFile.exists()) {
                    newFile.mkdirs();//以目录的形式创建
                }
            }
            copyDir(file,destFile);//递归
        }
    }

}
