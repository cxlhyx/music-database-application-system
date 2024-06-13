package com.example.music.service;

import com.example.music.entity.Company;
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
public interface ICompanyService extends IService<Company> {
    /**
     * 获取company全部数据
     */
    public List<Company> getAll(Map<String, Object> paramMap);

    /**
     * 根据id删除company数据
     *
     * @param id
     */
    public void delete(Integer id);
}
