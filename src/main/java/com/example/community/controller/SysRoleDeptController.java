package com.example.community.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.community.entity.SysRoleDept;
import com.example.community.service.SysRoleDeptService;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 角色和部门关联表(SysRoleDept)表控制层
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
@ApiIgnore
@RestController
@RequestMapping("sysRoleDept")
public class SysRoleDeptController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SysRoleDeptService sysRoleDeptService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param sysRoleDept 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<SysRoleDept> page, SysRoleDept sysRoleDept) {
        return success(this.sysRoleDeptService.page(page, new QueryWrapper<>(sysRoleDept)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.sysRoleDeptService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sysRoleDept 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody SysRoleDept sysRoleDept) {
        return success(this.sysRoleDeptService.save(sysRoleDept));
    }

    /**
     * 修改数据
     *
     * @param sysRoleDept 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody SysRoleDept sysRoleDept) {
        return success(this.sysRoleDeptService.updateById(sysRoleDept));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.sysRoleDeptService.removeByIds(idList));
    }
}

