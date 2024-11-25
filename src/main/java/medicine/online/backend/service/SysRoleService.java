package medicine.online.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.backend.common.result.PageResult;
import medicine.online.backend.model.entity.SysRole;
import medicine.online.backend.model.query.SysRoleQuery;
import medicine.online.backend.model.vo.SysRoleVO;

import java.util.List;

public interface SysRoleService extends IService<SysRole> {
    PageResult<SysRoleVO> page(SysRoleQuery query);

    List<SysRoleVO> getList(SysRoleQuery query);

    void save(SysRoleVO vo);

    void update(SysRoleVO vo);

    void delete(List<Integer> idList);
}
