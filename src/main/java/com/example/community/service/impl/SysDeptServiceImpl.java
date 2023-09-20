package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.SysDeptDao;
import com.example.community.entity.SysDept;
import com.example.community.service.SysDeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 部门表(SysDept)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:01
 */
@Service("sysDeptService")
public class SysDeptServiceImpl extends ServiceImpl<SysDeptDao, SysDept> implements SysDeptService {

    @Resource
    private SysDeptDao sysDeptDao;

    @Override
    public List<SysDept> selAllDept(SysDept sysDept) {
        return sysDeptDao.getDeptList(sysDept);
    }
}

