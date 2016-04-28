package com.tongdianer.zxy.site.xiaoyou.util;

import java.util.Random;

/**
 * Created by andy on 16-4-28.
 */
public class StringUtils {

    public static boolean isEmpty(String str){
        return str == null || "".equals(str.trim());
    }

    public static int randomInt() {
        Random random = new Random();
        return random.nextInt(9999);
    }



}
