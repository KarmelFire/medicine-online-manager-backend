package medicine.online.backend.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import medicine.online.backend.common.exception.ServerException;
import medicine.online.backend.common.model.BaseServiceImpl;
import medicine.online.backend.common.result.PageResult;
import medicine.online.backend.convert.SysManagerConvert;
import medicine.online.backend.model.entity.SysManager;
import medicine.online.backend.enums.SuperAdminEnum;
import medicine.online.backend.mapper.SysManagerMapper;
import medicine.online.backend.model.query.ChangePasswordQuery;
import medicine.online.backend.model.query.SysManagerQuery;
import medicine.online.backend.security.user.ManagerDetail;
import medicine.online.backend.service.SysManagerRoleService;
import medicine.online.backend.service.SysManagerService;
import medicine.online.backend.model.vo.SysManagerVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class SysManagerServiceImpl extends BaseServiceImpl<SysManagerMapper, SysManager> implements SysManagerService {

    private SysManagerRoleService sysManagerRoleService;

    @Override
    public PageResult<SysManagerVO> page(SysManagerQuery query) {
        Page<SysManagerVO> page = new Page<>(query.getPage(), query.getLimit());
        List<SysManagerVO> list = baseMapper.getManagerPage(page, query);
        return new PageResult<>(list, page.getTotal());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysManagerVO vo) {
        SysManager entity = SysManagerConvert.INSTANCE.convert(vo);
        entity.setSuperAdmin(SuperAdminEnum.NO.getValue());

        // 判断用户名是否存在
        SysManager manager = baseMapper.getByUsername(entity.getUsername());
        if (manager != null) {
            throw new ServerException("用户名已经存在");
        }
        // 保存用户
        baseMapper.insert(entity);
        // 保存用户角色关系
        sysManagerRoleService.saveOrUpdate(entity.getPkId(), vo.getRoleId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysManagerVO vo) {
        SysManager entity = SysManagerConvert.INSTANCE.convert(vo);
        // 判断用户名是否存在
        SysManager manager = baseMapper.getByUsername(entity.getUsername());
        if (manager != null && !manager.getPkId().equals(entity.getPkId())) {
            throw new ServerException("用户名已经存在");
        }
        // 更新用户
        updateById(entity);
        // 更新用户角色关系
        sysManagerRoleService.saveOrUpdate(entity.getPkId(), vo.getRoleId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Integer> idList) {
        // 删除管理员
        removeByIds(idList);
        // 删除用户角色关系
        sysManagerRoleService.removeByManagerId(idList);
    }

    @Override
    public SysManagerVO getManagerInfo(ManagerDetail manage) {
        SysManagerVO sysManagerVO = new SysManagerVO();
        System.out.println(">>>>>>getInfo" + manage.getPkId());
        SysManager sysManager = baseMapper.selectById(manage.getPkId());
        if (sysManager == null) {
            throw new ServerException("管理员不存在");
        }
        sysManagerVO.setPkId(sysManager.getPkId());
        sysManagerVO.setAvatar(sysManager.getAvatar());
        sysManagerVO.setUsername(sysManager.getUsername());
        sysManagerVO.setStatus(sysManager.getStatus());
        sysManagerVO.setRoleId(sysManagerRoleService.getByManagerId(manage.getPkId()).getRoleId());
        sysManagerVO.setCreateTime(sysManager.getCreateTime());
        return sysManagerVO;
    }

    @Override
    public void changePassword(ChangePasswordQuery query) {
        SysManager sysManager = baseMapper.selectById(query.getPkId());
        if (sysManager == null) {
            throw new ServerException("管理员不存在");
        }
        sysManager.setPassword(query.getPassword());
        updateById(sysManager);
    }
}
