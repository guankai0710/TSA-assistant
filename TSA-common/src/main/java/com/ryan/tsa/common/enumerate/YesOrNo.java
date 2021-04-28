package com.ryan.tsa.common.enumerate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类描述：是/否 枚举类
 *
 * @author ryan
 * @date 2021/4/28
 **/
public enum YesOrNo {

    /** 设备巡检 */
    DEVICE("3","设备巡检");

    public String value;

    public String name;

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    YesOrNo(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public static YesOrNo getByValue(String value) {
        for (YesOrNo obj : YesOrNo.values()) {
            if (value.equals(obj.getValue())){
                return obj;
            }
        }
        return null;
    }

    public static YesOrNo getByName(String name) {
        for (YesOrNo obj : YesOrNo.values()) {
            if (name.equals(obj.getName())){
                return obj;
            }
        }
        return null;
    }

    public static List<Map<String,Object>> getMaps() {
        List<Map<String ,Object>> list = new ArrayList<>();
        for (YesOrNo obj : YesOrNo.values()) {
            Map<String,Object> map = new HashMap<>(16);
            map.put("value",obj.value);
            map.put("name",obj.name);
            list.add(map);
        }
        return list;
    }
}
