package com.closet.onlinecloset.controller;

import sun.misc.BASE64Decoder;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class utools {
    // 对字节数组字符串进行Base64解码并生成图片
    //imgFilePath 待保存的本地路径
    public static boolean GenerateImage(String base64Str, String imgFilePath) {
        if (base64Str == null) // 图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] bytes = decoder.decodeBuffer(base64Str);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }
            }
            // 生成jpeg图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(bytes);
            out.flush();
            out.close();
            //====
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
