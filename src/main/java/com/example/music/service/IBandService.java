package com.example.music.service;

import com.example.music.entity.Band;
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
public interface IBandService extends IService<Band> {
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
