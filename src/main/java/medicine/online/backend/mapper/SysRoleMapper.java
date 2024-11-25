package medicine.online.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import medicine.online.backend.model.entity.SysRole;
import medicine.online.backend.model.query.SysRoleQuery;
import medicine.online.backend.model.vo.SysRoleVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysRoleVO> getRolePage(Page<SysRoleVO> page, @Param("query") SysRoleQuery query);

}
