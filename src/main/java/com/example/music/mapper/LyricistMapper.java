package com.example.music.mapper;

import com.example.music.entity.Lyricist;
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
public interface LyricistMapper extends BaseMapper<Lyricist> {
    /**
     * 获取Lyricist全部数据
     */
    public List<Lyricist> getAll(Map<String, Object> paramMap);

    /**
     * 根据id删除Lyricist数据
     * @param id
     */
    public void delete(Integer id);
}
