package com.example.music.service;

import com.example.music.entity.Composer;
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
public interface IComposerService extends IService<Composer> {
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
