package com.example.community.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.community.dto.sysUserAndDepts;
import com.example.community.entity.SysRole;
import com.example.community.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import com.example.community.entity.SysDept;

/**
 * 部门表(SysDept)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-14 09:53:01
 */
public interface SysDeptDao extends BaseMapper<SysDept> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysDept> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysDept> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysDept> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<SysDept> entities);

    /**
     * 部门表单新增修改的树形结构
     *
     * @return
     */
    List<SysDept> getDeptList(SysDept sysDept);

    List<SysDept> getDeptLists(SysDept sysDept);

    List<SysDept> getDept(SysDept sysDept);

    Integer deleteDept(String deptId);

    List<SysDept> isChildren(String deptId);

    List<SysUser> isUser(String deptId);

    public List<SysDept> selectRoleName(long id);

    Integer insetDept(SysDept sysDept);

    Integer updateDept(SysDept sysDept);

    Integer updateDeptlis(String status,long id);

    SysDept checkName(String deptName, String deptId, String parentId);

    SysDept getById(String deptId);

    //折线图
    List<String> getByIds();

    sysUserAndDepts getDeptLis(String id);

}

