package com.example.community.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.community.dto.ExVisitor;
import com.example.community.dto.ExZyRepair;
import com.example.community.dto.ZyRepairDto;
import com.example.community.entity.SysUser;
import com.example.community.entity.ValueLabel;
import com.example.community.entity.ZyRepair;
import com.example.community.mini.dto.RepairDto;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 报修信息(ZyRepair)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-14 09:53:04
 */
public interface ZyRepairDao extends BaseMapper<ZyRepair> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ZyRepair> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ZyRepair> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ZyRepair> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ZyRepair> entities);

    long count(@Param("zyRepairDto") ZyRepairDto zyRepairDto, @Param("id") long id);

    List<ZyRepairDto> selectZyRepairDto(@Param("index") Long index, @Param("size") Long size, @Param("zyRepairDto") ZyRepairDto zyRepairDto, @Param("id") long id);

    List<RepairDto> selectAllRepairs(@Param("communityId") String communityId, @Param("userId") String userId);

    Integer deleteRepair(@Param("updateBy")String updateBy, @Param("repairId") String repairId,@Param("date") Date date);

    Integer completeRepair(@Param("updateBy")String updateBy, @Param("repairId") String repairId,@Param("date") Date date);

    Integer reRepair(RepairDto repairDto);

    List<SysUser> getUserList(long id);

    Integer updateRepair(ZyRepair zyRepair);

    Integer selectDoorTime(String time);

    String getNumber(String name);

    List<ZyRepair> getZyRepairList();

    List<ValueLabel> repairHouse(Long communityId, Long ownerId);

    List<ExZyRepair> getZyRepairListS(List<String> list);

}

