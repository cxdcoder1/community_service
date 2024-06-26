package com.example.community.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 房屋绑定记录表 (ZyOwnerRoomRecord)表实体类
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
@SuppressWarnings("serial")
public class ZyOwnerRoomRecord extends Model<ZyOwnerRoomRecord> {


    //房屋绑定记录id
    private Long recordId;
    //房屋绑定id
    private String ownerRoomId;
    //小区id
    private Long communityId;
    //楼栋id
    private Long buildingId;
    //单元id
    private Long unitId;
    //房间id
    private Long roomId;
    //业主id
    private Long ownerId;
    //业主类型
    private String ownerType;
    //绑定状态（0审核中 1绑定 2审核失败,3解绑）
    private String roomStatus;
    //审核意见
    private String recordAuditOpinion;
    //审核人类型
    private String recordAuditType;
    //创建人id
    private Long createById;
    //创建者
    private String createBy;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String createTime;
    //更新者
    private String updateBy;
    //更新时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String updateTime;
    //备注
    private String remark;


    public ZyOwnerRoomRecord() {
    }

    public ZyOwnerRoomRecord(Long recordId, String ownerRoomId, Long communityId, Long buildingId, Long unitId, Long roomId, Long ownerId, String ownerType, String roomStatus, String recordAuditOpinion, String recordAuditType, Long createById, String createBy, String createTime, String updateBy, String updateTime, String remark) {
        this.recordId = recordId;
        this.ownerRoomId = ownerRoomId;
        this.communityId = communityId;
        this.buildingId = buildingId;
        this.unitId = unitId;
        this.roomId = roomId;
        this.ownerId = ownerId;
        this.ownerType = ownerType;
        this.roomStatus = roomStatus;
        this.recordAuditOpinion = recordAuditOpinion;
        this.recordAuditType = recordAuditType;
        this.createById = createById;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.remark = remark;
    }

    /**
     * 获取
     * @return recordId
     */
    public Long getRecordId() {
        return recordId;
    }

    /**
     * 设置
     * @param recordId
     */
    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    /**
     * 获取
     * @return ownerRoomId
     */
    public String getOwnerRoomId() {
        return ownerRoomId;
    }

    /**
     * 设置
     * @param ownerRoomId
     */
    public void setOwnerRoomId(String ownerRoomId) {
        this.ownerRoomId = ownerRoomId;
    }

    /**
     * 获取
     * @return communityId
     */
    public Long getCommunityId() {
        return communityId;
    }

    /**
     * 设置
     * @param communityId
     */
    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    /**
     * 获取
     * @return buildingId
     */
    public Long getBuildingId() {
        return buildingId;
    }

    /**
     * 设置
     * @param buildingId
     */
    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    /**
     * 获取
     * @return unitId
     */
    public Long getUnitId() {
        return unitId;
    }

    /**
     * 设置
     * @param unitId
     */
    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    /**
     * 获取
     * @return roomId
     */
    public Long getRoomId() {
        return roomId;
    }

    /**
     * 设置
     * @param roomId
     */
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    /**
     * 获取
     * @return ownerId
     */
    public Long getOwnerId() {
        return ownerId;
    }

    /**
     * 设置
     * @param ownerId
     */
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * 获取
     * @return ownerType
     */
    public String getOwnerType() {
        return ownerType;
    }

    /**
     * 设置
     * @param ownerType
     */
    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    /**
     * 获取
     * @return roomStatus
     */
    public String getRoomStatus() {
        return roomStatus;
    }

    /**
     * 设置
     * @param roomStatus
     */
    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    /**
     * 获取
     * @return recordAuditOpinion
     */
    public String getRecordAuditOpinion() {
        return recordAuditOpinion;
    }

    /**
     * 设置
     * @param recordAuditOpinion
     */
    public void setRecordAuditOpinion(String recordAuditOpinion) {
        this.recordAuditOpinion = recordAuditOpinion;
    }

    /**
     * 获取
     * @return recordAuditType
     */
    public String getRecordAuditType() {
        return recordAuditType;
    }

    /**
     * 设置
     * @param recordAuditType
     */
    public void setRecordAuditType(String recordAuditType) {
        this.recordAuditType = recordAuditType;
    }

    /**
     * 获取
     * @return createById
     */
    public Long getCreateById() {
        return createById;
    }

    /**
     * 设置
     * @param createById
     */
    public void setCreateById(Long createById) {
        this.createById = createById;
    }

    /**
     * 获取
     * @return createBy
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置
     * @param createBy
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取
     * @return createTime
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置
     * @param createTime
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取
     * @return updateBy
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置
     * @param updateBy
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取
     * @return updateTime
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置
     * @param updateTime
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String toString() {
        return "ZyOwnerRoomRecord{recordId = " + recordId + ", ownerRoomId = " + ownerRoomId + ", communityId = " + communityId + ", buildingId = " + buildingId + ", unitId = " + unitId + ", roomId = " + roomId + ", ownerId = " + ownerId + ", ownerType = " + ownerType + ", roomStatus = " + roomStatus + ", recordAuditOpinion = " + recordAuditOpinion + ", recordAuditType = " + recordAuditType + ", createById = " + createById + ", createBy = " + createBy + ", createTime = " + createTime + ", updateBy = " + updateBy + ", updateTime = " + updateTime + ", remark = " + remark + "}";
    }
}
