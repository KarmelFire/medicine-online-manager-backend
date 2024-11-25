package medicine.online.backend.convert;

import medicine.online.backend.model.dto.DictConfigRequestDTO;
import medicine.online.backend.model.entity.DictConfig;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DictConfigConvert {
    DictConfigConvert INSTANCE = Mappers.getMapper(DictConfigConvert.class);


    DictConfig convertToConfig(DictConfigRequestDTO dto);
}
