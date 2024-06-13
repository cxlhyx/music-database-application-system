package com.example.music.service;

import com.example.music.entity.Lyricist;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cxlhyx
 * @since 2024-5-31
 */
public interface ILyricistService extends IService<Lyricist> {
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
