package com.example.music.service.impl;

import com.example.music.entity.Album;
import com.example.music.entity.Company;
import com.example.music.mapper.AlbumMapper;
import com.example.music.mapper.CompanyMapper;
import com.example.music.service.IAlbumService;
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
public class AlbumServiceImpl extends ServiceImpl<AlbumMapper, Album> implements IAlbumService {
    @Autowired
    private AlbumMapper albumMapper;

    @Override
    public List<Album> getAll(Map<String, Object> paramMap) {
        return albumMapper.getAll(paramMap);
    }

    @Override
    public void delete(Integer id) {
        albumMapper.delete(id);
    }
}
