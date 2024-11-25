package medicine.online.backend.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName FileUrlVO
 * @Description TODO
 * @Author BC
 * @Date 2024/11/24 15:52
 * @Version 1.0
 */
@Data
@Schema(description = "图片url上传地址")
@AllArgsConstructor
public class FileUrlVO {

    @Schema(description = "file_url")
    private String fileUrl;
}