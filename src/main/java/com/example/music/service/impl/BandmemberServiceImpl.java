package com.example.music.service.impl;

import com.example.music.entity.Bandmember;
import com.example.music.entity.Company;
import com.example.music.mapper.BandmemberMapper;
import com.example.music.mapper.CompanyMapper;
import com.example.music.service.IBandmemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cxlhyx
 * @since 2024-5-31
 */
@Service
public class BandmemberServiceImpl extends ServiceImpl<BandmemberMapper, Bandmember> implements IBandmemberService {
    @Autowired
    private BandmemberMapper bandmemberMapper;

    @Override
    public List<Bandmember> getAll(Map<String, Object> paramMap) {
        return bandmemberMapper.getAll(paramMap);
    }

    @Override
    public Bandmember get(Map<String, Object> paramMap) {
        return bandmemberMapper.get(paramMap);
    }

    @Override
    public void delete(Map<String, Object> paramMap) {
        bandmemberMapper.delete(paramMap);
    }

    @Override
    public void edit(Map<String, Object> paramMap) {
        bandmemberMapper.edit(paramMap);
    }
}
