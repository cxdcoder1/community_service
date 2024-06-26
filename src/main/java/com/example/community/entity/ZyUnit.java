package com.example.community.entity;


import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.util.Date;

/**
 * 单元 (ZyUnit)表实体类
 *
 * @author makejava
 * @since 2023-09-14 09:53:04
 */
@SuppressWarnings("serial")
@ColumnWidth(15) //列宽,最大值为255
@HeadRowHeight(16) //表头行高
@ContentRowHeight(16) //数据行高
public class ZyUnit extends Model<ZyUnit> {
    //单元id
    @ExcelProperty(index = 0, value = {"单元id"})
    private Long unitId;
    //小区id
    @ExcelProperty(index = 2, value = {"小区id"})
    private Long communityId;
    //楼栋id
    @ExcelProperty(index = 3, value = {"楼栋id"})
    private Long buildingId;
    //单元名称
    @ExcelProperty(index = 4, value = {"单元名称"})
    private String unitName;
    //单元编号
    @ExcelProperty(index = 5, value = {"单元编号"})
    private String unitCode;
    //层数
    @ExcelProperty(index = 6, value = {"层数"})
    private Integer unitLevel;
    //建筑面积
    @ExcelProperty(index = 7, value = {"建筑面积"})
    private Double unitAcreage;
    //是否有电梯
    @ExcelProperty(index = 8, value = {"是否有电梯"})
    private String unitHaveElevator;
    //创建者
    @ExcelIgnore
    private String createBy;
    //创建时间
    @ExcelIgnore
    private Date createTime;
    //更新者
    @ExcelIgnore
    private String updateBy;
    //更新时间
    @ExcelIgnore
    private Date updateTime;
    //备注
    @ExcelProperty(index = 9, value = {"备注"})
    private String remark;

    @Override
    public String toString() {
        return "ZyUnit{" +
                "unitId=" + unitId +
                ", communityId=" + communityId +
                ", buildingId=" + buildingId +
                ", unitName='" + unitName + '\'' +
                ", unitCode='" + unitCode + '\'' +
                ", unitLevel=" + unitLevel +
                ", unitAcreage=" + unitAcreage +
                ", unitHaveElevator='" + unitHaveElevator + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                ", remark='" + remark + '\'' +
                '}';
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public Integer getUnitLevel() {
        return unitLevel;
    }

    public void setUnitLevel(Integer unitLevel) {
        this.unitLevel = unitLevel;
    }

    public Double getUnitAcreage() {
        return unitAcreage;
    }

    public void setUnitAcreage(Double unitAcreage) {
        this.unitAcreage = unitAcreage;
    }

    public String getUnitHaveElevator() {
        return unitHaveElevator;
    }

    public void setUnitHaveElevator(String unitHaveElevator) {
        this.unitHaveElevator = unitHaveElevator;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}

