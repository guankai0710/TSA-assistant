package com.ryan.tsa.common.enumerate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类描述：性别 枚举类
 *
 * @author ryan
 * @date 2021/4/28
 **/
public enum Sex {

    MAN(1,"男"),
    WOMAN(0,"女");

    public Integer value;

    public String name;

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    Sex(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public static Sex getByValue(Integer value) {
        for (Sex obj : Sex.values()) {
            if (value.equals(obj.getValue())){
                return obj;
            }
        }
        return null;
    }

    public static Sex getByName(String name) {
        for (Sex obj : Sex.values()) {
            if (name.equals(obj.getName())){
                return obj;
            }
        }
        return null;
    }

    public static List<Map<String,Object>> getMaps() {
        List<Map<String ,Object>> list = new ArrayList<>();
        for (Sex obj : Sex.values()) {
            Map<String,Object> map = new HashMap<>(16);
            map.put("value",obj.value);
            map.put("name",obj.name);
            list.add(map);
        }
        return list;
    }
}
