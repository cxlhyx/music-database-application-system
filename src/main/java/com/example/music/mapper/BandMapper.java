package com.example.music.mapper;

import com.example.music.entity.Album;
import com.example.music.entity.Band;
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
public interface BandMapper extends BaseMapper<Band> {
    /**
     * 获取Band全部数据
     */
    public List<Band> getAll(Map<String, Object> paramMap);

    /**
     * 根据id删除Band数据
     * @param id
     */
    public void delete(Integer id);
}
