package com.example.music.service;

import com.example.music.entity.Bandmember;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author cxlhyx
 * @since 2024-5-31
 */
public interface IBandmemberService extends IService<Bandmember> {
    /**
     * 获取Bandmember全部数据
     *
     * @param paramMap
     * @return Bandmember List
     */
    public List<Bandmember> getAll(Map<String, Object> paramMap);

    /**
     * 获取Bandmember某个数据
     *
     * @param paramMap
     * @return Bandmember
     */
    public Bandmember get(Map<String, Object> paramMap);

    /**
     * 根据id删除Bandmember数据
     *
     * @param paramMap
     */
    public void delete(Map<String, Object> paramMap);

    /**
     * 根据id更新Bandmember数据
     *
     * @param paramMap
     */
    public void edit(Map<String, Object> paramMap);
}
