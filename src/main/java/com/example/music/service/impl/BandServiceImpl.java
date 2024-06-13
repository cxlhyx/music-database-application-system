package com.example.music.service.impl;

import com.example.music.entity.Band;
import com.example.music.mapper.BandMapper;
import com.example.music.service.IBandService;
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
public class BandServiceImpl extends ServiceImpl<BandMapper, Band> implements IBandService {
    @Autowired
    private BandMapper bandMapper;

    @Override
    public List<Band> getAll(Map<String, Object> paramMap) {
        return bandMapper.getAll(paramMap);
    }

    @Override
    public void delete(Integer id) {
        bandMapper.delete(id);
    }
}
