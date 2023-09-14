package com.example.community.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.community.entity.ZyCommunity;
import com.example.community.service.ZyCommunityService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 小区 (ZyCommunity)表控制层
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
@RestController
@RequestMapping("zyCommunity")
public class ZyCommunityController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ZyCommunityService zyCommunityService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param zyCommunity 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<ZyCommunity> page, ZyCommunity zyCommunity) {
        return success(this.zyCommunityService.page(page, new QueryWrapper<>(zyCommunity)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.zyCommunityService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param zyCommunity 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody ZyCommunity zyCommunity) {
        return success(this.zyCommunityService.save(zyCommunity));
    }

    /**
     * 修改数据
     *
     * @param zyCommunity 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody ZyCommunity zyCommunity) {
        return success(this.zyCommunityService.updateById(zyCommunity));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.zyCommunityService.removeByIds(idList));
    }
}

