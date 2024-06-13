package com.example.music.mapper;

import com.example.music.entity.Song;
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
public interface SongMapper extends BaseMapper<Song> {
    /**
     * 获取Song全部数据
     */
    public List<Song> getAll(Map<String, Object> paramMap);

    /**
     * 根据id删除Song数据
     * @param id
     */
    public void delete(Integer id);
}
