package medicine.online.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.backend.common.result.PageResult;
import medicine.online.backend.model.entity.SysManager;
import medicine.online.backend.model.query.ChangePasswordQuery;
import medicine.online.backend.model.query.SysManagerQuery;
import medicine.online.backend.security.user.ManagerDetail;
import medicine.online.backend.model.vo.SysManagerVO;

import java.util.List;

public interface SysManagerService extends IService<SysManager> {

    /**
     * 管理员列表
     *
     * @param query
     * @return
     */
    PageResult<SysManagerVO> page(SysManagerQuery query);

    /**
     * 新增管理员
     *
     * @param vo
     */
    void save(SysManagerVO vo);

    /**
     * 修改管理员信息
     *
     * @param vo
     */
    void update(SysManagerVO vo);

    /**
     * 删除管理员信息
     *
     * @param idList
     */
    void delete(List<Integer> idList);

    /**
     * 修改密码
     *
     * @param query
     */

    void changePassword(ChangePasswordQuery query);

    /**
     * 获取管理员信息
     *
     * @param manage
     * @return
     */

    SysManagerVO getManagerInfo(ManagerDetail manage);
}
