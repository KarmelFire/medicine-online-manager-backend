package medicine.online.backend.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import medicine.online.backend.model.entity.SysManager;
import medicine.online.backend.model.query.SysManagerQuery;
import medicine.online.backend.model.vo.SysManagerVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysManagerMapper extends BaseMapper<SysManager> {

    default SysManager getByUsername(String username){
        return this.selectOne(new LambdaQueryWrapper<SysManager>().eq(SysManager::getUsername, username));
    }

    List<SysManagerVO> getManagerPage(Page<SysManagerVO> page, @Param("query") SysManagerQuery query);
}
