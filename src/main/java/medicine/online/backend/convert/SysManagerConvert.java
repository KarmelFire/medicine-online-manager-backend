package medicine.online.backend.convert;

import medicine.online.backend.model.entity.SysManager;
import medicine.online.backend.security.user.ManagerDetail;
import medicine.online.backend.model.vo.SysManagerVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SysManagerConvert {
    SysManagerConvert INSTANCE = Mappers.getMapper(SysManagerConvert.class);

    SysManager convert(SysManagerVO vo);

    ManagerDetail convertDetail(SysManager entity);

    List<SysManagerVO> convertList(List<SysManager> list);
}
