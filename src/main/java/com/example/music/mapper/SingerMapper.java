package com.example.music.mapper;

import com.example.music.entity.Singer;
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
public interface SingerMapper extends BaseMapper<Singer> {
    /**
     * 获取Singer全部数据
     */
    public List<Singer> getAll(Map<String, Object> paramMap);

    /**
     * 根据id删除Singer数据
     * @param id
     */
    public void delete(Integer id);
}
