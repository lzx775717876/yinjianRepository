package com.yinjiansystem.yinjian.utils;


import java.util.*;

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

    //List去重不改变原有顺序
    public static void removeDuplicateWithOrder(List list) {
        Set set = new HashSet();
        List newList = new ArrayList();
        for (Iterator iter = list.iterator(); iter.hasNext();) {
            Object element = iter.next();
            if (set.add(element))
                newList.add(element);
        }
        list.clear();
        list.addAll(newList);
    }
	
}
