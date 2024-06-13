package com.example.music.service.impl;

import com.example.music.entity.Song;
import com.example.music.mapper.SongMapper;
import com.example.music.service.ISongService;
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
public class SongServiceImpl extends ServiceImpl<SongMapper, Song> implements ISongService {
    @Autowired
    private SongMapper songMapper;

    @Override
    public List<Song> getAll(Map<String, Object> paramMap) {
        return songMapper.getAll(paramMap);
    }

    @Override
    public void delete(Integer id) {
        songMapper.delete(id);
    }
}
