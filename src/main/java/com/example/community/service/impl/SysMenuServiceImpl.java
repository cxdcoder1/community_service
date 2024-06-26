package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.SysMenuDao;
import com.example.community.entity.SysMenu;
import com.example.community.entity.SysUser;
import com.example.community.service.SysMenuService;
import com.example.community.utils.MenuTree;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//import com.example.community.utils.MenuTree;

/**
 * 菜单权限表(SysMenu)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenu> implements SysMenuService {

    @Resource
    private SysMenuDao sysMenuDao;

    @Override
    public List<SysMenu> MenuTree(int id) {
        List<SysMenu> sysMenuList = sysMenuDao.selectMenuTreeByUserId(id);
        MenuTree menuTree = new MenuTree(sysMenuList);
        List<SysMenu> sysMenuList1 = menuTree.builTree();
        return sysMenuList1;

    }

    @Override
    public List<SysMenu> getMenuList(String menuName,String status) {
        List<SysMenu> menuList = sysMenuDao.getMenuList(menuName, status);
//        System.err.println(menuList+"2222222222");
//        menuList.sort(new Comparator<SysMenu>() {
//            @Override
//            public int compare(SysMenu o1, SysMenu o2) {
//                return o1.getOrderNum() - o2.getOrderNum();
//            }
//        });
        return menuList;
    }


    @Override
    public Boolean checkName(String menuName, String menuId, String parentId) {
        Long id = sysMenuDao.checkName(menuName, parentId);
        if (id==null){
            return true;
        }else {
            if (String.valueOf(id).equals(menuId)){
                return true;
            }
            return false;
        }
    }

    @Override
    public Boolean checkPath(String menuName, String menuId) {
        Long id = sysMenuDao.checkPath(menuName, menuId);
        if (id==null){
            return true;
        }else {
            if (String.valueOf(id).equals(menuId)){
                return true;
            }
            return false;
        }
    }

    @Override
    public Integer updateMenu(SysMenu sysMenu) {
        return sysMenuDao.updateMenu(sysMenu);

    }

    @Override
    public Integer addMenu(SysMenu sysMenu) {
        return sysMenuDao.addMenu(sysMenu);
    }

    @Override
    public SysMenu getParent(SysMenu sysMenu) {
        return sysMenuDao.getParent(sysMenu.getParentId()+"");
    }

    @Override
    public List<SysMenu> getMenuChildren(SysMenu sysMenu) {
        return sysMenuDao.getMenuChildren(sysMenu);
    }

    @Override
    public Integer upTypeToM(SysMenu sysMenu) {

        return sysMenuDao.upTypeToM(sysMenu);
    }

    @Override
    public String deleteMenu(Long menuId, Long parentId) {
        List<SysMenu> menu = sysMenuDao.getMenuByParentId(menuId);
        if (menu.size()!=0){
            return "该菜单有子菜单,不能删除!";
        }else {
            int i = sysMenuDao.deleteByMenuId(menuId);
            if (i==1) {
                return "删除成功!";
            }
            return "删除失败！";
        }
    }

    @Override
    public List<SysMenu> MenuList() {
        List<SysMenu> sysMenuList = sysMenuDao.MenuList();
        MenuTree menuTree = new MenuTree(sysMenuList);
        List<SysMenu> sysMenuList1 = menuTree.builTree();
        return sysMenuList1;
    }


//    @Override
//    public List<SysMenu> getMenuList(String menuName, String status) {
//        List<SysMenu> sysMenuList = sysMenuDao.getMenuList(menuName,status);
//        MenuTree menuTree = new MenuTree(sysMenuList);
//        List<SysMenu> sysMenuList1 = menuTree.builTree();
//        return sysMenuList1;
//    }

    @Override
    public Set<String> getMenuPermission(SysUser user)
    {
        Set<String> perms = new HashSet<String>();

        perms.addAll(sysMenuDao.selectMenuPermsByUserId(user.getUserId()));

        return perms;
    }
}

