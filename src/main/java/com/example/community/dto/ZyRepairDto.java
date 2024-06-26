package com.example.community.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.util.Date;

/**
 * @author zhf
 */
@Getter
public class ZyRepairDto {
    //报修ID
    private Long repairId;
    //业主电话
    private String ownerPhoneNumber;
    //业主名字
    private  String ownerRealName;
    //报修编号
    private String repairNum;
    //报修状态
    private String repairState;
    //派单时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date assignmentTime;
    //接单时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date receivingOrdersTime;
    //处理完成时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date completeTime;
    //取消时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date cancelTime;
    //期待上门时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date doorTime;
    //分派人id
    private Long assignmentId;
    //处理人id
    private Long completeId;
    //处理人电话
    private String completePhone;
    //处理人姓名
    private String completeName;
    //备注
    private String remark;
    //创建者
    private String createBy;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    //更新者
    private String updateBy;
    //更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    //创建人id
    private Long userId;
    //删除状态0默认1删除
    private Integer delFlag;
    //报修内容
    private String repairContent;
    //小区ID
    private Long communityId;
    //详细地址
    private String address;

    public String getOwnerPhoneNumber() {
        return ownerPhoneNumber;
    }

    public void setOwnerPhoneNumber(String ownerPhoneNumber) {
        this.ownerPhoneNumber = ownerPhoneNumber;
    }

    public Long getRepairId() {
        return repairId;
    }

    public void setRepairId(Long repairId) {
        this.repairId = repairId;
    }

    public String getRepairNum() {
        return repairNum;
    }

    public void setRepairNum(String repairNum) {
        this.repairNum = repairNum;
    }

    public String getRepairState() {
        return repairState;
    }

    public void setRepairState(String repairState) {
        this.repairState = repairState;
    }

    public Date getAssignmentTime() {
        return assignmentTime;
    }

    public void setAssignmentTime(Date assignmentTime) {
        this.assignmentTime = assignmentTime;
    }

    public Date getReceivingOrdersTime() {
        return receivingOrdersTime;
    }

    public void setReceivingOrdersTime(Date receivingOrdersTime) {
        this.receivingOrdersTime = receivingOrdersTime;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public Date getDoorTime() {
        return doorTime;
    }

    public void setDoorTime(Date doorTime) {
        this.doorTime = doorTime;
    }

    public Long getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Long assignmentId) {
        this.assignmentId = assignmentId;
    }

    public Long getCompleteId() {
        return completeId;
    }

    public void setCompleteId(Long completeId) {
        this.completeId = completeId;
    }

    public String getCompletePhone() {
        return completePhone;
    }

    public void setCompletePhone(String completePhone) {
        this.completePhone = completePhone;
    }

    public String getCompleteName() {
        return completeName;
    }

    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getRepairContent() {
        return repairContent;
    }

    public void setRepairContent(String repairContent) {
        this.repairContent = repairContent;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getOwnerRealName() {
        return ownerRealName;
    }

    public void setOwnerRealName(String ownerRealName) {
        this.ownerRealName = ownerRealName;
    }

    @Override
    public String toString() {
        return "ZyRepairDto{" +
                "repairId=" + repairId +
                ", ownerPhoneNumber='" + ownerPhoneNumber + '\'' +
                ", ownerRealName='" + ownerRealName + '\'' +
                ", repairNum='" + repairNum + '\'' +
                ", repairState='" + repairState + '\'' +
                ", assignmentTime=" + assignmentTime +
                ", receivingOrdersTime=" + receivingOrdersTime +
                ", completeTime=" + completeTime +
                ", cancelTime=" + cancelTime +
                ", doorTime=" + doorTime +
                ", assignmentId=" + assignmentId +
                ", completeId=" + completeId +
                ", completePhone='" + completePhone + '\'' +
                ", completeName='" + completeName + '\'' +
                ", remark='" + remark + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                ", userId=" + userId +
                ", delFlag=" + delFlag +
                ", repairContent='" + repairContent + '\'' +
//                ", communityId=" + communityId +
                ", address='" + address + '\'' +
                '}';
    }
}
