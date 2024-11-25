package medicine.online.backend.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import medicine.online.backend.model.entity.User;
import medicine.online.backend.model.query.UserQuery;
import medicine.online.backend.model.vo.UserInfoVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据手机号获取用户
     *
     * @param phone 手机号
     * @return 用户信息
     */
    default User getByPhone(String phone) {
        return this.selectOne(new LambdaQueryWrapper<User>().eq(User::getPhone, phone));
    }

    /**
     * 分页获取用户信息
     *
     * @param page  分页参数
     * @param query 查询条件
     * @return 用户信息列表
     */
    List<UserInfoVO> getUserPage(Page<UserInfoVO> page, @Param("query") UserQuery query);
}
