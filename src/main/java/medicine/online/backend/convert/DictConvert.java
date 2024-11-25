package medicine.online.backend.convert;

import medicine.online.backend.model.dto.DictRequestDTO;
import medicine.online.backend.model.entity.Dict;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DictConvert {
    DictConvert INSTANCE = Mappers.getMapper(DictConvert.class);


    Dict convertToDict(DictRequestDTO dto);
}
