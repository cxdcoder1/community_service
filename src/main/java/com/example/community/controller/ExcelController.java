package com.example.community.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.fastjson.JSON;
import com.example.community.dto.UserAndDeptImport;
import com.example.community.entity.SysDictData;
import com.example.community.entity.SysDictType;
import com.example.community.entity.SysPost;
import com.example.community.entity.SysRole;
import com.example.community.service.SysDictDataService;
import com.example.community.service.SysDictTypeService;
import com.example.community.service.SysPostService;
import com.example.community.service.SysRoleService;
import com.example.community.listener.DemoDataListener;
import com.example.community.service.*;
import com.example.community.utils.easyexcel.StyleUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Excel表格导出
 */
@RestController
@RequestMapping("excel")
@CrossOrigin
public class ExcelController {

    @Resource
    private SysRoleService sysRoleService;
    @Resource
    private SysDictDataService sysDictDataService;
    @Resource
    private SysDictTypeService sysDictTypeService;
    @Resource
    private SysUserService sysUserService;
    @Resource
    private SysPostService sysPostService;

    /**
     * 生成随机文件名 并返回固定路径
     * @return
     */
    static String getPath() {
        UUID randomUUID = UUID.randomUUID();
        String s = randomUUID.toString().replaceAll("-", "");
        return "D:\\"+s+".xls";
    }

    /**
     * 导出数据
     * @param fileName
     * @param list
     */
    public static void simpleWrite(String fileName,List<SysRole> list){
        //"E:\\lx.xls"
        List<SysRole> dataList = new ArrayList<>();
        for (SysRole sysRole : list) {
            dataList.add(sysRole);
        }
        // 设置单元格样式
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy( StyleUtils.getHeadStyle(),StyleUtils.getContentStyle());

        EasyExcel.write(fileName, SysRole.class)
                .sheet(0)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .doWrite(dataList);
    }

    /**
     * 岗位
     * @param fileName
     * @param list
     */
    public static void simpleWrites(String fileName,List<SysPost> list){
        //"E:\\lx.xls"
        List<SysPost> dataList = new ArrayList<>();

        for (SysPost sysPost : list) {
            dataList.add(sysPost);
        }

        // 设置单元格样式
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy( StyleUtils.getHeadStyle(),StyleUtils.getContentStyle());

        EasyExcel.write(fileName, SysPost.class)
                .sheet(0)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .doWrite(dataList);
    }

    /**
     * 导出用户数据
     * @param fileName
     * @param list
     */
    public static void simpleWriteUser(String fileName,List<UserAndDeptImport> list){
        //"E:\\lx.xls"
        List<UserAndDeptImport> dataList = new ArrayList<>();

        for (UserAndDeptImport userAndDeptImport : list) {
            dataList.add(userAndDeptImport);
        }

        // 设置单元格样式
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy( StyleUtils.getHeadStyle(),StyleUtils.getContentStyle());

        EasyExcel.write(fileName, UserAndDeptImport.class)
                .sheet(0)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .doWrite(dataList);
    }

    /**
     * 导入用户
     */
    @PostMapping("into")
    public Map<String,Object> simpleRead(@RequestParam("file") MultipartFile file) {
        Map<String,Object> result = new HashMap<>();
//        String fileName = "F:\\rdtext.xls";
        List<UserAndDeptImport> dataList = new ArrayList<>();
        //每次会读取100条数据然后返回过来，直接调用使用数据就行
        try {
            EasyExcel.read(file.getInputStream(), UserAndDeptImport.class, new DemoDataListener(dataList))
                    .sheet(0)//读取第一个sheet
    //                .headRowNumber(3) //跳过前三行表头内容，假如是简单表头则这句可省略
                    .doRead();
        } catch (IOException e) {
            //文件类型不对
            e.printStackTrace();
        }

//        for (UserAndDeptImport dl : dataList) {
//            System.err.println(JSON.toJSONString(dl));
//            System.out.println("*****************");
//            System.err.println(dl);
//        }
        //验空
        if (dataList.size()==0){
            result.put("status",201);
            result.put("msg","请导入有数据的xls文件");
            return result;
        }
        //验重
        Map<String, Object> m1 = sysUserService.checkUserName(dataList);
        if (m1.get("status").equals("false")){
            result.put("status",201);
            result.put("msg",m1.get("msg"));
            return result;
        }
        Map<String, Object> m2 = sysUserService.checkPhone(dataList);
        if (m2.get("status").equals("false")){
            result.put("status",201);
            result.put("msg",m2.get("msg"));
            return result;
        }
        //批量插入
        try {
            sysUserService.batchInsert(dataList);
        } catch (Exception e) {
            result.put("status",201);
            result.put("msg","导入失败，请检查字段是否填入完整");
            return result;
        }
        result.put("status",200);
        result.put("msg","导入成功");
        return result;
    }

    public static void simpleWrite1(String fileName,List<SysDictData> list){
        //"E:\\lx.xls"
        List<SysDictData> dataList = new ArrayList<>();

        for (SysDictData sysDictData : list) {
            dataList.add(sysDictData);
        }

        // 设置单元格样式
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy( StyleUtils.getHeadStyle(),StyleUtils.getContentStyle());

        EasyExcel.write(fileName, SysDictData.class)
                .sheet(0)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .doWrite(dataList);
    }

    //Dictexcel
    public static void Dictexcel(String fileName,List<SysDictType> userList){
        //"E:\\lx.xls"
        List<SysDictType> dataList = new ArrayList<>();

        for (SysDictType sysDictType : userList) {
            dataList.add(sysDictType);
        }
        // 设置单元格样式
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy( StyleUtils.getHeadStyle(),StyleUtils.getContentStyle());
        EasyExcel.write(fileName, SysDictType.class)
                .sheet(0)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .doWrite(dataList);
    }


    /**
     * 角色表格导出
     * @param lists
     * @return
     */
    @PostMapping("list")
    public Map<String, Object> menuList(@RequestBody List<String> lists) {
        Map<String, Object> result = new HashMap<>();
        //根据需要导出的角色id查询对应信息
        if (lists.size()==0){
            lists=null;
        }
        System.err.println(lists);

        List<SysRole> deriveList = sysRoleService.getDeriveList(lists);

        String path = getPath();
        simpleWrite(path,deriveList);
        result.put("msg","导出成功");
        result.put("status","200");
        result.put("path",path);
        return result;
    }

    /**
     * 用户表格导出
     * @param lists
     * @return
     */
    @PostMapping("userList")
    public Map<String, Object> UserList(@RequestBody List<String> lists) {
        Map<String, Object> result = new HashMap<>();
        //根据需要导出的角色id查询对应信息
        if (lists.size()==0){
            lists=null;
        }

        List<UserAndDeptImport> userList = sysUserService.getUserList(lists);
//        System.err.println(userList);
        String path = getPath();
        simpleWriteUser(path,userList);
        result.put("msg","导出成功");
        result.put("status","200");
        result.put("path",path);
        return result;
    }

    /**
     * 用户导入模板
     * @return
     */
    @PostMapping("template")
    public Map<String, Object> template() {
        Map<String, Object> result = new HashMap<>();


        List<UserAndDeptImport> userList = new ArrayList<>();
//        System.err.println(userList);
        String path = getPath();
        simpleWriteUser(path,userList);
        result.put("msg","模板导出成功");
        result.put("status","200");
        result.put("path",path);
        return result;
    }



    @PostMapping("list2")
    public Map<String, Object> menuList1(@RequestBody List<String> lists) {
        Map<String, Object> result = new HashMap<>();
        //根据需要导出的角色id查询对应信息
        if (lists.size()==0){
            lists=null;
        }
        System.err.println(lists);

        List<SysDictData> deriveList = sysDictDataService.getDeriveList(lists);
        String path = "D:\\lx.xls";
        simpleWrite1(path,deriveList);
        result.put("msg","导出成功");
        result.put("status","200");
        result.put("path",path);
        return result;
    }

    /**
     * 角色表格导出
     * @param lists
     * @return
     */
    @PostMapping("DictList")
    public Map<String, Object> DictList(@RequestBody List<String> lists) {
        Map<String, Object> result = new HashMap<>();
        //根据需要导出的角色id查询对应信息
        if (lists.size()==0){
            lists=null;
        }
        System.err.println(lists);
        List<SysDictType> deriveList = sysDictTypeService.getDeriveList(lists);
        String path = "F:\\lx.xls";
        Dictexcel(path,deriveList);
        result.put("msg","导出成功");
        result.put("status","200");
        result.put("path",path);
        return result;
    }

    @PostMapping("postListS")
    public Map<String, Object> postList(@RequestBody List<String> lists) {
        Map<String, Object> result = new HashMap<>();
        if (lists.size()==0){
            lists=null;
        }
        List<SysPost> postList = sysPostService.getPostList(lists);
        String path="D:\\lx.xls";
        simpleWrites(path,postList);
        result.put("msg","导出成功");
        result.put("status","200");
        result.put("path",path);
        return result;
    }
}
