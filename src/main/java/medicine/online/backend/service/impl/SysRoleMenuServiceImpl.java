package medicine.online.backend.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import medicine.online.backend.model.entity.SysRoleMenu;
import medicine.online.backend.mapper.SysRoleMenuMapper;
import medicine.online.backend.service.SysRoleMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {


    @Override
    public List<Integer> getMenuIdList(Integer roleId){
        return baseMapper.getMenuIdList(roleId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByMenuId(Integer menuId) {
        remove(new LambdaQueryWrapper<SysRoleMenu>().eq(SysRoleMenu::getMenuId, menuId));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdate(Integer roleId, List<Integer> menuIdList) {
    // 数据库菜单ID列表
        List<Integer> dbMenuIdList = getMenuIdList(roleId);

        // 需要新增的菜单ID
        Collection<Integer> insertMenuIdList = CollUtil.subtract(menuIdList, dbMenuIdList);
        if (CollUtil.isNotEmpty(insertMenuIdList)){
            List<SysRoleMenu> menuList = insertMenuIdList.stream().map(menuId -> {
                SysRoleMenu entity = new SysRoleMenu();
                entity.setMenuId(menuId);
                entity.setRoleId(roleId);
                return entity;
            }).collect(Collectors.toList());

            // 批量新增
            saveBatch(menuList);
        }

        // 需要删除的菜单ID
        Collection<Integer> deleteMenuIdList = CollUtil.subtract(dbMenuIdList, menuIdList);
        if (CollUtil.isNotEmpty(deleteMenuIdList)){
            LambdaQueryWrapper<SysRoleMenu> queryWrapper = new LambdaQueryWrapper<>();
            remove(queryWrapper.eq(SysRoleMenu::getRoleId, roleId).in(SysRoleMenu::getMenuId, deleteMenuIdList));
        }
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByRoleIdList(List<Integer> roleIdList) {
        remove(new LambdaQueryWrapper<SysRoleMenu>().in(SysRoleMenu::getRoleId, roleIdList));
    }

}
