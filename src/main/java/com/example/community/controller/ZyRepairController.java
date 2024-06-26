package com.example.community.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.community.dto.ZyRepairDto;
import com.example.community.entity.ZyRepair;
import com.example.community.service.ZyRepairService;
import io.swagger.annotations.Api;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 报修信息(ZyRepair)表控制层
 *
 * @author makejava
 * @since 2023-09-14 09:53:04
 */
@Api(tags = "保修管理")
@RestController
@RequestMapping("zyRepair")
@CrossOrigin
@Component
public class ZyRepairController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ZyRepairService zyRepairService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param zyRepair 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<ZyRepair> page, ZyRepair zyRepair) {
        return success(this.zyRepairService.page(page, new QueryWrapper<>(zyRepair)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.zyRepairService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param zyRepair 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody ZyRepair zyRepair) {
        return success(this.zyRepairService.save(zyRepair));
    }

    /**
     * 修改数据
     *
     * @param zyRepair 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody ZyRepair zyRepair) {
        return success(this.zyRepairService.updateById(zyRepair));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.zyRepairService.removeByIds(idList));
    }

    @GetMapping("zyRepairDtoList")
    public R zyRepair(Page<ZyRepairDto> page, ZyRepairDto zyRepairDto, Long communityId) {
        return success(this.zyRepairService.zyRepairDtoList(page,zyRepairDto,communityId));
    }

    @PostMapping("getUserList/{communityId}")
    public R getUserList(@PathVariable  Long communityId) {
        return success(this.zyRepairService.getUserList(communityId));
    }

    @PutMapping("edit")
    public Map<String, Object> edit(@RequestBody ZyRepair zyRepair) {
        Map<String, Object> map = new HashMap<>();
        Integer integer = zyRepairService.updateRepair(zyRepair);
        map.put("msg","修改成功");
        map.put("status", 200);
        map.put("success", true);
        return map;
    }
    @PostMapping("getNumber")
    public R getNumber(@PathParam("name") String name) {
        return success(this.zyRepairService.getNumber(name));
    }

    /**
     * 定时任务 每天9点查询七天处理中状态的报修 如果七天后还没有确认完成，自动完成
     * @throws ParseException
     */
    @Scheduled(cron = "0 0 9 * * ?")
    public void checkRepairStatus() throws ParseException {
        // 查询所有报修信息
        List<ZyRepair> zyRepairs = zyRepairService.getZyRepairList();
        for (ZyRepair repair : zyRepairs) {
            // 计算报修信息的创建时间与当前时间的差值
            String doorTimeString = repair.getDoorTime();
            // 获取 doorTime 字符串
            String pattern = "yyyy-MM-dd HH:mm:ss";
            // 根据 doorTime 的实际格式指定匹配模式
            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
            Date doorTime = formatter.parse(repair.getDoorTime());
            long timeDiff = System.currentTimeMillis() -doorTime.getTime();
            long daysDiff = timeDiff / (24 * 60 * 60 * 1000);
            // 如果超过七天，修改状态为完成
            if (daysDiff >= 7) {
                repair.setRepairState("2");
                zyRepairService.updateRepair(repair);
            }
        }

    }

}

