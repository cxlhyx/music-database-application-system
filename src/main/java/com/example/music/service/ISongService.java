package com.example.music.service;

import com.example.music.entity.Song;
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
public interface ISongService extends IService<Song> {
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
