package com.example.music.service.impl;

import com.example.music.entity.Company;
import com.example.music.mapper.CompanyMapper;
import com.example.music.service.ICompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cxlhyx
 * @since 2024-5-31
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements ICompanyService {
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public List<Company> getAll(Map<String, Object> paramMap) {
        return companyMapper.getAll(paramMap);
    }

    @Override
    public void delete(Integer id) {
        companyMapper.delete(id);
    }
}
