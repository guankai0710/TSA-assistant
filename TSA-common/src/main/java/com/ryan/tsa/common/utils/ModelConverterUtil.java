package com.ryan.tsa.common.utils;

import com.ryan.tsa.common.exception.BusinessException;
import com.ryan.tsa.common.response.ResultCode;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 实体类转换工具类
 *
 * @author ryan
 * @date 2021/9/7
 **/
public class ModelConverterUtil {

    private ModelConverterUtil() { }

    /**
     * 创建类实例
     *
     * @param beanCalss
     * @author ryan
     * @date 2021/9/7
     * @return
     **/
    public static <T> T newInstance(Class<T> beanCalss){
        try {
            return beanCalss.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException(ResultCode.SERVER_ERROR);
        }
    }

    /**
     * 属性拷贝
     *
     * @param source 源对象
     * @param target 目标对象
     * @author ryan
     * @date 2021/9/7
     * @return
     **/
    public static void copyProperties(Object source, Object target){
        if (source == null){ return; }
        BeanUtils.copyProperties(source, target);
    }

    /**
     * 对象转换
     *
     * @param source 源对象
     * @param targetClass 目标对象类型
     * @author ryan
     * @date 2021/9/7
     * @return
     **/
    public static <T> T convert(Object source, Class<T> targetClass){
        if (source == null){ return null; }
        T target = newInstance(targetClass);
        copyProperties(source, target);
        return target;
    }

    /**
     * 对象集合转换
     *
     * @param sources 源对象集合
     * @param targetClass 目标对象类型
     * @author ryan
     * @date 2021/9/7
     * @return
     **/
    public static <T> List<T> convert(Collection<?> sources, Class<T> targetClass){
        if (sources == null){ return null; }
       List<T> targets = new ArrayList<>(16);
        if (!CollectionUtils.isEmpty(sources)){
            targets = sources.stream().map(x -> convert(x,targetClass)).collect(Collectors.toList());
        }
        return targets;
    }

}
