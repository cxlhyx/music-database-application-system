package com.example.music.service.impl;

import com.example.music.entity.Singsong;
import com.example.music.mapper.SingsongMapper;
import com.example.music.service.ISingsongService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cxlhyx
 * @since 2024-5-31
 */
@Service
public class SingsongServiceImpl extends ServiceImpl<SingsongMapper, Singsong> implements ISingsongService {
    @Autowired
    private SingsongMapper singsongMapper;

    @Override
    public List<Singsong> getAll(Map<String, Object> paramMap) {
        return singsongMapper.getAll(paramMap);
    }

    @Override
    public Singsong get(Map<String, Object> paramMap) {
        return singsongMapper.get(paramMap);
    }

    @Override
    public void delete(Map<String, Object> paramMap) {
        singsongMapper.delete(paramMap);
    }

    @Override
    public void edit(Map<String, Object> paramMap) {
        singsongMapper.edit(paramMap);
    }
}
