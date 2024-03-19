package com.Ilaunch.Ilaunch.util;

import java.util.UUID;

public class Helper {
    public static boolean isNullOrEmpty(String help){
        if(help == null || help.isEmpty()){
            return true;
        }
        return false;
    }

    public static String generateId(){// to randomly assign an ID
        return UUID.randomUUID().toString();
    }

    public static Integer generateId2(){// to randomly assign an ID
        return UUID.randomUUID().hashCode();
    }
}
