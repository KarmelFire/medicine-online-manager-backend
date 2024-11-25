package medicine.online.backend.convert;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.WriteCellData;
import medicine.online.backend.enums.AccountStatusEnum;
/**
 * @ClassName UserEnabledConverter
 * @Description TODO
 * @Author BC
 * @Date 2024/11/24 19:06
 * @Version 1.0
 */
public class UserEnabledConverter implements Converter<Integer> {

    @Override
    public Class<?> supportJavaTypeKey() {
        return String.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public WriteCellData<?> convertToExcelData(WriteConverterContext<Integer> context) {
        return new WriteCellData<>(AccountStatusEnum.getNameByValue(context.getValue()));
    }
}

