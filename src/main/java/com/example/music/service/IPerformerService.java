package com.example.music.service;

import com.example.music.entity.Performer;
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
public interface IPerformerService extends IService<Performer> {
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
