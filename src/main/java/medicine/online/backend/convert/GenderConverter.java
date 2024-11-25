package medicine.online.backend.convert;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.WriteCellData;

/**
 * @ClassName GenderConverter
 * @Description TODO
 * @Author BC
 * @Date 2024/11/24 19:04
 * @Version 1.0
 */
public class GenderConverter implements Converter<Integer> {

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
        Integer value = context.getValue();
        if (value == 0) {
            return new WriteCellData<>("男");
        } else if (value == 1) {
            return new WriteCellData<>("女");
        } else {
            return new WriteCellData<>("未知");
        }
    }
}
