package com.example.music.service.impl;

import com.example.music.entity.Performer;
import com.example.music.mapper.PerformerMapper;
import com.example.music.service.IPerformerService;
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
public class PerformerServiceImpl extends ServiceImpl<PerformerMapper, Performer> implements IPerformerService {
    @Autowired
    private PerformerMapper performerMapper;

    @Override
    public List<Performer> getAll(Map<String, Object> paramMap) {
        return performerMapper.getAll(paramMap);
    }

    @Override
    public void delete(Integer id) {
        performerMapper.delete(id);
    }
}
