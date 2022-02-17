package com.study.hello.spring.fw;

import java.io.*;
import java.util.Base64;

/**
 * @Author: fangxiangqian
 * @Date: 2022/1/31
 */
public class ImageTest {
    public static void main(String[] args) throws IOException {
        String fileBase64="";
        FileReader fileReader = new FileReader("C:\\Users\\fangxiangqian\\Desktop\\base64test.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line =null;
        while ((line=bufferedReader.readLine())!=null){
            fileBase64 = fileBase64+line;
        }
        bufferedReader.close();
        fileReader.close();
        //过滤掉base64中一些头部的信息
        if (fileBase64.contains("base64,")) {
            fileBase64 = fileBase64.substring(fileBase64.indexOf("base64,") + 6);
        }
        byte[] decode = Base64.getMimeDecoder().decode(fileBase64);
        String path = "C:\\Users\\fangxiangqian\\Desktop\\test1.jpg";

        createFileWithByte(decode, path);
    }




    /**
     * 根据byte数组生成文件
     *
     * @param bytes 生成文件用到的byte数组
     */
    public static void createFileWithByte(byte[] bytes, String path) {
        // TODO Auto-generated method stub
        /**
         * 创建File对象，其中包含文件所在的目录以及文件的命名
         */
        File file = new File(path);
        // 创建FileOutputStream对象
        FileOutputStream outputStream = null;
        // 创建BufferedOutputStream对象
        BufferedOutputStream bufferedOutputStream = null;
        try {
            // 如果文件存在则删除
            if (file.exists()) {
                file.delete();
            }
            // 在文件系统中根据路径创建一个新的空文件
            file.createNewFile();
            // 获取FileOutputStream对象
            outputStream = new FileOutputStream(file);
            // 获取BufferedOutputStream对象
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            // 往文件所在的缓冲输出流中写byte数据
            bufferedOutputStream.write(bytes);
            // 刷出缓冲输出流，该步很关键，要是不执行flush()方法，那么文件的内容是空的。
            bufferedOutputStream.flush();
        } catch (Exception e) {
            // 打印异常信息
            e.printStackTrace();
        } finally {
            // 关闭创建的流对象
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
