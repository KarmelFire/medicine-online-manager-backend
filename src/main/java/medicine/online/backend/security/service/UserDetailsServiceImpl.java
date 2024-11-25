package medicine.online.backend.security.service;

import medicine.online.backend.model.entity.SysManager;
import medicine.online.backend.mapper.SysManagerMapper;
import medicine.online.backend.service.SysManagerDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final SysManagerDetailsService sysManagerDetailsService;
    private final SysManagerMapper sysManagerMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysManager sysManager = sysManagerMapper.getByUsername(username);
        if (sysManager == null) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        return sysManagerDetailsService.getManagerDetails(sysManager);
    }
}
