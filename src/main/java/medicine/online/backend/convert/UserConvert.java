package medicine.online.backend.convert;

import medicine.online.backend.model.dto.UserEditDTO;
import medicine.online.backend.model.entity.User;
import medicine.online.backend.model.vo.UserInfoVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);
    List<UserInfoVO> convert(List<User> list);
    User convert(UserEditDTO dto);
}
