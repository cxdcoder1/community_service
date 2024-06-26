package com.example.community.entity;


import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 操作日志记录(SysOperLog)表实体类
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
@SuppressWarnings("serial")
@Getter
@Setter
@ColumnWidth(15) //列宽,最大值为255
@HeadRowHeight(16) //表头行高
@ContentRowHeight(16) //数据行高
public class SysOperLog extends Model<SysOperLog> {

    //日志主键
    @ColumnWidth(8)//单独设置列宽
    @ExcelProperty(index = 0, value = {"ID"})
    private Long operId;
    //模块标题
    @ExcelProperty(index = 1, value = {"模块标题"})
    private String title;
    //业务类型（0其它 1新增 2修改 3删除）
    @ExcelProperty(index = 2,  value = {"业务类型（0=其它,1=新增,2=修改,3=删除,4=授权,5=导出,6=导入,7=强退,8=生成代码,9=清空数据）"})
    private Integer businessType;
    //方法名称
    @ExcelProperty(index = 3, value = {"方法名称"})
    private String method;
    //请求方式
    @ExcelProperty(index = 4, value = {"请求方式"})
    private String requestMethod;
    //操作类别（0其它 1后台用户 2手机端用户）
    @ExcelProperty(index = 5, value = {"操作类别(0=其他，1=后台用户，3=手机端用户)"})
    private Integer operatorType;
    //操作人员
    @ExcelProperty(index = 6, value = {"操作人员"})
    private String operName;
    //部门名称
    @ExcelProperty(index = 7, value = {"部门名称"})
    private String deptName;
    //请求URL
    @ExcelProperty(index = 8, value = {"请求URL"})
    private String operUrl;
    //主机地址
    @ExcelProperty(index = 9, value = {"主机地址"})
    private String operIp;
    //操作地点
    @ExcelProperty(index = 10, value = {"操作地点"})
    private String operLocation;
    //请求参数
    @ExcelProperty(index = 11, value = {"请求参数"})
    private String operParam;
    //返回参数
    @ExcelProperty(index = 12, value = {"返回参数"})
    private String jsonResult;
    //操作状态（0正常 1异常）
    @ExcelProperty(index = 13, value = {"操作状态（0=正常 1=异常）"})
    private Integer status;
    //错误消息
    @ExcelProperty(index = 14, value = {"错误消息"})
    private String errorMsg;
    //操作时间
    @ExcelIgnore
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date operTime;




    public Long getOperId() {
        return operId;
    }

    public void setOperId(Long operId) {
        this.operId = operId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public Integer getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(Integer operatorType) {
        this.operatorType = operatorType;
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getOperUrl() {
        return operUrl;
    }

    public void setOperUrl(String operUrl) {
        this.operUrl = operUrl;
    }

    public String getOperIp() {
        return operIp;
    }

    public void setOperIp(String operIp) {
        this.operIp = operIp;
    }

    public String getOperLocation() {
        return operLocation;
    }

    public void setOperLocation(String operLocation) {
        this.operLocation = operLocation;
    }

    public String getOperParam() {
        return operParam;
    }

    public void setOperParam(String operParam) {
        this.operParam = operParam;
    }

    public String getJsonResult() {
        return jsonResult;
    }

    public void setJsonResult(String jsonResult) {
        this.jsonResult = jsonResult;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.operId;
    }
    }

