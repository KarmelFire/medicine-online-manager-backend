package medicine.online.backend.model.query;


import lombok.EqualsAndHashCode;
import medicine.online.backend.common.model.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "字典查询")
public class DictQuery extends Query {
    @Schema(description = "字典名称")
    private String title;
}
