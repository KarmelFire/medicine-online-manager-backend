package medicine.online.backend.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import medicine.online.backend.common.model.Query;

/**
 * @ClassName UserQuery
 * @Description TODO
 * @Author BC
 * @Date 2024/11/24 17:48
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "⽤户查询")
public class UserQuery extends Query {

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "⼿机号")
    private String phone;

    @Schema(description = "性别")
    private Integer gender;
}

