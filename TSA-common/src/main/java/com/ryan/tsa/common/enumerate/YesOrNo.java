package com.ryan.tsa.common.enumerate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 是/否 枚举类
 * </p>
 *
 * @author Ryan
 * @since 2021-08-14
 */
public enum YesOrNo {

    /** 是 */
    YES(1,"是"),

    /** 否 */
    NO(0,"否");

    public Integer value;

    public String name;

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    YesOrNo(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public static YesOrNo getByValue(Integer value) {
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
