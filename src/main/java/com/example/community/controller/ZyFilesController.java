package com.example.community.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.community.entity.ZyFiles;
import com.example.community.service.ZyFilesService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 文件管理(ZyFiles)表控制层
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
@Api(tags = "文件管理")
@RestController
@RequestMapping("zyFiles")
public class ZyFilesController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ZyFilesService zyFilesService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param zyFiles 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<ZyFiles> page, ZyFiles zyFiles) {
        return success(this.zyFilesService.page(page, new QueryWrapper<>(zyFiles)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.zyFilesService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param zyFiles 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody ZyFiles zyFiles) {
        return success(this.zyFilesService.save(zyFiles));
    }

    /**
     * 修改数据
     *
     * @param zyFiles 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody ZyFiles zyFiles) {
        return success(this.zyFilesService.updateById(zyFiles));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.zyFilesService.removeByIds(idList));
    }
}

