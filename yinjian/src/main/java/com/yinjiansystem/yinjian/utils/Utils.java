package com.yinjiansystem.yinjian.utils;



/**
 * @Description 工具类
 * @Author DT
 * @Date 2020/11/27
 */
public class Utils {

    //判断字符串是否为空
    public static boolean stringEmptyOrNull(String string) {
        return string == null || string.trim().length() <= 0;
    }
	
}
