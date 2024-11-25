package medicine.online.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.servlet.http.HttpServletResponse;
import medicine.online.backend.common.result.PageResult;
import medicine.online.backend.model.dto.UserEditDTO;
import medicine.online.backend.model.entity.User;
import medicine.online.backend.model.query.UserQuery;
import medicine.online.backend.model.vo.UserInfoVO;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author BC
 * @Date 2024/11/24 18:05
 * @Version 1.0
 */
public interface UserService  extends IService<User> {
    PageResult<UserInfoVO> page(UserQuery query);
    void update(UserEditDTO dto);
    void export(UserQuery query, HttpServletResponse response);
    void enabled(Integer userId);
}
