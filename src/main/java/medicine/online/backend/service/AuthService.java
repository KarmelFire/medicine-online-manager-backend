package medicine.online.backend.service;

import medicine.online.backend.model.vo.SysAccountLoginVO;
import medicine.online.backend.model.vo.SysTokenVO;

public interface AuthService {

    /**
     * 使用账号密码登录
     * @param params
     * @return
     */
    SysTokenVO loginByAccount(SysAccountLoginVO params);

    /**
     * 退出登录
     *
     * @param accessToken accessToken
     */
    void logout(String accessToken);

}
