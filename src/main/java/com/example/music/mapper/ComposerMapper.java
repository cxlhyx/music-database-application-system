package com.example.music.mapper;

import com.example.music.entity.Composer;
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
public interface ComposerMapper extends BaseMapper<Composer> {
    /**
     * 获取Composer全部数据
     */
    public List<Composer> getAll(Map<String, Object> paramMap);

    /**
     * 根据id删除Composer数据
     *
     * @param id
     */
    public void delete(Integer id);
}
