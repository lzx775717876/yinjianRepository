package com.yinjiansystem.yinjian.utils;


import java.util.*;

/**
 * @Description 工具类
 * @Author DT
 * @Date 2020/11/27
 */
public class Utils {

    /**
     * 判断字符串是否为空
     * @param string 目标字符串
     * @return boolean
     */
    public static boolean stringEmptyOrNull(String string) {
        return string == null || string.trim().length() <= 0;
    }

    /**
     * List去重不改变原有顺序
     * @param list 目标list
     */
    public static <T> void removeDuplicateWithOrder(List<T> list) {
        HashSet<T> set = new HashSet<>();
        List<T> newList = new ArrayList<>();
        for (T element : list) {
            if (set.add(element)) {
                newList.add(element);
            }
        }
        list.clear();
        list.addAll(newList);
    }
	
}
