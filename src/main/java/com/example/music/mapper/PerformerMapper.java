package com.example.music.mapper;

import com.example.music.entity.Performer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Map;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cxlhyx
 * @since 2024-5-31
 */
public interface PerformerMapper extends BaseMapper<Performer> {
    /**
     * 获取Performer全部数据
     */
    public List<Performer> getAll(Map<String, Object> paramMap);

    /**
     * 根据id删除Performer数据
     * @param id
     */
    public void delete(Integer id);
}
