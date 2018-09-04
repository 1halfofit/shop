package com.bo.util;

import java.util.UUID;

public class UUIDutil {
    //生成随机的uuid方法
    public static String  getuuid(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
