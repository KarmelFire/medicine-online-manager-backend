package medicine.online.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.backend.model.entity.SysMenu;
import medicine.online.backend.model.query.SysMenuQuery;
import medicine.online.backend.security.user.ManagerDetail;
import medicine.online.backend.model.vo.SysMenuVO;

import java.util.List;
import java.util.Set;

public interface SysMenuService extends IService<SysMenu> {

    /**
     * 用户菜单列表
     *
     * @param type 菜单类型
     */
    List<SysMenuVO> getManagerMenuList(ManagerDetail manager,String type);

    Set<String> getManagerAuthority(ManagerDetail manager);

    /**
     * 菜单列表
     *
     * @param query 菜单筛选
     */
    List<SysMenuVO> getMenuList(SysMenuQuery query);

    SysMenuVO infoById(Integer id);

    void save(SysMenuVO vo);


    void update(SysMenuVO vo);

    void delete(Integer id);

    List<SysMenu> getFormMenuList();

    List<SysMenuVO> getRoleFormMenuList();
    /**
     * 获取子菜单的数量
     * @param pid  父菜单ID
     */
    Long getSubMenuCount(Integer pid);


}
