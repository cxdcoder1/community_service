package com.example.community.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.community.dto.ExVisitor;
import com.example.community.dto.ExZyOwnerRoom;
import com.example.community.dto.ZyOwnerRoomDto;
import org.apache.ibatis.annotations.Param;
import com.example.community.entity.ZyVisitor;

/**
 * 访客邀请 (ZyVisitor)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-14 09:53:04
 */
public interface ZyVisitorDao extends BaseMapper<ZyVisitor> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ZyVisitor> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ZyVisitor> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ZyVisitor> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ZyVisitor> entities);

    Integer insertByV(ZyVisitor zyVisitor);

    List<ZyVisitor> getByCommunityId(@Param("communityId") Long communityId,@Param("ownerId") Long ownerId);

    List<ZyVisitor> getByComS(@Param("communityId") Long communityId,@Param("ownerId") Long ownerId);

    long count(ZyVisitor zyVisitor, long id);

    List<ZyVisitor> selectZyVisitor(@Param("index") Long index, @Param("size") Long size , @Param("zyVisitor") ZyVisitor zyVisitor, @Param("id")long id);

    List<ExVisitor> getZyVisitorList(List<String> list);

    Integer updateRemark(long id);

    Integer updateRemarks(long id);

}

