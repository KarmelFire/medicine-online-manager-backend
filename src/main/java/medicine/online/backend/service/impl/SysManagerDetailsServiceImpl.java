package medicine.online.backend.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import medicine.online.backend.convert.SysManagerConvert;
import medicine.online.backend.enums.AccountStatusEnum;
import medicine.online.backend.model.entity.SysManager;
import medicine.online.backend.security.user.ManagerDetail;
import medicine.online.backend.service.SysManagerDetailsService;
import medicine.online.backend.service.SysMenuService;

import java.util.Set;

@Service
@AllArgsConstructor
public class SysManagerDetailsServiceImpl implements SysManagerDetailsService {
    private final SysMenuService sysMenuService;

    @Override
    public UserDetails getManagerDetails(SysManager sysManager) {
        // 转换成UserDetail对象
        ManagerDetail managerDetail = SysManagerConvert.INSTANCE.convertDetail(sysManager);

        // 账号不可用
        if (sysManager.getStatus() == AccountStatusEnum.DISABLE.getValue()) {
            managerDetail.setEnabled(false);
        }

        // 用户权限列表
        Set<String> authoritySet = sysMenuService.getManagerAuthority(managerDetail);
        managerDetail.setAuthoritySet(authoritySet);

        return managerDetail;
    }

}
