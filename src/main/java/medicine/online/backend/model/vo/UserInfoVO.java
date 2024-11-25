package medicine.online.backend.model.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import medicine.online.backend.convert.GenderConverter;
import medicine.online.backend.convert.UserEnabledConverter;

import java.time.LocalDateTime;

/**
 * @ClassName UserInfoVO
 * @Description TODO
 * @Author BC
 * @Date 2024/11/24 17:53
 * @Version 1.0
 */
@Data
@Schema(name = "UserInfoVO", description = "⽤户信息返回 vo")
public class UserInfoVO {

    @ExcelIgnore
    @Schema(name = "pk_id", description = "⽤户 id")
    private Integer pkId;

    @ExcelProperty("昵称")
    @Schema(name = "nickname", description = "昵称")
    private String nickname;

    @ExcelProperty("⼿机号")
    @Schema(name = "phone", description = "⼿机号")
    private String phone;

    @ExcelProperty("微信 openid")
    @Schema(name = "wxOpenId", description = "微信 openid")
    private String wxOpenId;

    @ExcelProperty("头像")
    @Schema(name = "avatar", description = "头像")
    private String avatar;

    @ExcelProperty(value = "性别", converter = GenderConverter.class)
    @Schema(name = "gender", description = "性别")
    private Integer gender;

    @ExcelProperty("⽣⽇")
    @Schema(name = "birthday", description = "⽣⽇")
    private String birthday;

    @ExcelProperty("积分")
    @Schema(name = "bonus", description = "积分")
    private Integer bonus;

    @ExcelProperty("备注")
    @Schema(name = "remark", description = "备注")
    private String remark;

    @ExcelProperty(value = "账户状态", converter = UserEnabledConverter.class)
    @Schema(description = "账户状态")
    private Integer enabled;

    @ExcelProperty("创建时间")
    @Schema(name = "createTime", description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
}
