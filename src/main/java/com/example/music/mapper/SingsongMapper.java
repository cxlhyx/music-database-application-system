package com.example.music.mapper;

import com.example.music.entity.Bandmember;
import com.example.music.entity.Singsong;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Map;
import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author cxlhyx
 * @since 2024-5-31
 */
public interface SingsongMapper extends BaseMapper<Singsong> {
    /**
     * 获取Singsong全部数据
     *
     * @param paramMap
     * @return Singsong List
     */
    public List<Singsong> getAll(Map<String, Object> paramMap);

    /**
     * 获取Singsong某个数据
     *
     * @param paramMap
     * @return Singsong
     */
    public Singsong get(Map<String, Object> paramMap);

    /**
     * 根据id删除Singsong数据
     *
     * @param paramMap
     */
    public void delete(Map<String, Object> paramMap);

    /**
     * 根据id更新Singsong数据
     *
     * @param paramMap
     */
    public void edit(Map<String, Object> paramMap);
}
