package com.example.music.service.impl;

import com.example.music.entity.Singer;
import com.example.music.mapper.SingerMapper;
import com.example.music.service.ISingerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cxlhyx
 * @since 2024-5-31
 */
@Service
public class SingerServiceImpl extends ServiceImpl<SingerMapper, Singer> implements ISingerService {
    @Autowired
    private SingerMapper singerMapper;

    @Override
    public List<Singer> getAll(Map<String, Object> paramMap) {
        return singerMapper.getAll(paramMap);
    }

    @Override
    public void delete(Integer id) {
        singerMapper.delete(id);
    }
}
