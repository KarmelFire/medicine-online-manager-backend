package medicine.online.backend.service.impl;

import medicine.online.backend.common.exception.ServerException;
import medicine.online.backend.security.cache.TokenStoreCache;
import medicine.online.backend.security.user.ManagerDetail;
import medicine.online.backend.security.utils.TokenUtils;
import medicine.online.backend.service.AuthService;
import medicine.online.backend.model.vo.SysAccountLoginVO;
import medicine.online.backend.model.vo.SysTokenVO;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final TokenStoreCache tokenStoreCache;
    private final AuthenticationManager authenticationManager;

    @Override
    public SysTokenVO loginByAccount(SysAccountLoginVO params) {
        Authentication authentication;
        try {
            // 用户认证
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(params.getUsername(), params.getPassword()));
        } catch (DisabledException e) {
            throw new ServerException("该账号已被禁用");
        } catch (BadCredentialsException e) {
            throw new ServerException("用户名或密码错误");
        }
        // 用户信息
        ManagerDetail user = (ManagerDetail) authentication.getPrincipal();
        // 生成 accessToken
        String accessToken = TokenUtils.generator();
        // 保存用户信息到缓存
        tokenStoreCache.saveUser(accessToken, user);

        return new SysTokenVO(accessToken);
    }

    @Override
    public void logout(String accessToken) {
        // 用户信息
        ManagerDetail manager = tokenStoreCache.getUser(accessToken);

        // 删除用户信息
        tokenStoreCache.deleteUser(accessToken);

    }

}
