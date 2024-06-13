package com.example.music.service.impl;

import com.example.music.entity.Lyricist;
import com.example.music.mapper.LyricistMapper;
import com.example.music.service.ILyricistService;
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
public class LyricistServiceImpl extends ServiceImpl<LyricistMapper, Lyricist> implements ILyricistService {
    @Autowired
    private LyricistMapper lyricistMapper;

    @Override
    public List<Lyricist> getAll(Map<String, Object> paramMap) {
        return lyricistMapper.getAll(paramMap);
    }

    @Override
    public void delete(Integer id) {
        lyricistMapper.delete(id);
    }
}
