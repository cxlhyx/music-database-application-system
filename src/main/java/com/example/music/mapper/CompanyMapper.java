package com.example.music.mapper;

import com.example.music.entity.Company;
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
public interface CompanyMapper extends BaseMapper<Company> {
    /**
     * 获取Company全部数据
     */
    public List<Company> getAll(Map<String, Object> paramMap);

    /**
     * 根据id删除Company数据
     * @param id
     */
    public void delete(Integer id);
}
