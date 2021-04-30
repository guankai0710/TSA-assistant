package com.ryan.tsa.common.service.impl;

import com.ryan.tsa.common.domain.SysDictionary;
import com.ryan.tsa.common.mapper.SysDictionaryMapper;
import com.ryan.tsa.common.service.SysDictionaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ryan.tsa.common.vo.SysDictionaryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 系统字典  服务实现类
 * </p>
 *
 * @author ryan
 * @since 2021-04-28
 */
@Service
@Slf4j
public class SysDictionaryServiceImpl extends ServiceImpl<SysDictionaryMapper, SysDictionary> implements SysDictionaryService {

    @Autowired
    private SysDictionaryMapper sysDictionaryMapper;

    @Override
    public List<SysDictionaryVo> getByTypeCode(String typeCode) {
        return Optional.ofNullable(sysDictionaryMapper.getByTypeCode(typeCode)).orElse(new ArrayList<>());
    }
}
