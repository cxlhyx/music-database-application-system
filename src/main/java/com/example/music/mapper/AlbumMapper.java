package com.example.music.mapper;

import com.example.music.entity.Album;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cxlhyx
 * @since 2024-5-31
 */
public interface AlbumMapper extends BaseMapper<Album> {
    /**
     * 获取Album全部数据
     */
    public List<Album> getAll(Map<String, Object> paramMap);

    /**
     * 根据id删除Album数据
     * @param id
     */
    public void delete(Integer id);
}
