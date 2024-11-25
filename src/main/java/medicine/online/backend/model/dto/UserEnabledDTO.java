package medicine.online.backend.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @ClassName UserEnabledDTO
 * @Description TODO
 * @Author BC
 * @Date 2024/11/24 19:13
 * @Version 1.0
 */
@Data
@Schema(description = "用户状态修改dto")
public class UserEnabledDTO {

    @Schema(description = "用户id")
    private Integer pkId;

    @Schema(description = "账户状态")
    private Integer enabled;
}
