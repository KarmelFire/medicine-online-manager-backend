package medicine.online.backend.mapper;

import medicine.online.backend.model.entity.SysRoleMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

    /**
     * 根据角色ID，获取菜单ID列表
     */
    List<Integer> getMenuIdList(@Param("roleId") Integer roleId);

}
