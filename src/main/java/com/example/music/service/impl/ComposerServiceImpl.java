package com.example.music.service.impl;

import com.example.music.entity.Composer;
import com.example.music.mapper.ComposerMapper;
import com.example.music.service.IComposerService;
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
public class ComposerServiceImpl extends ServiceImpl<ComposerMapper, Composer> implements IComposerService {
    @Autowired
    private ComposerMapper composerMapper;

    @Override
    public List<Composer> getAll(Map<String, Object> paramMap) {
        return composerMapper.getAll(paramMap);
    }

    @Override
    public void delete(Integer id) {
        composerMapper.delete(id);
    }
}
