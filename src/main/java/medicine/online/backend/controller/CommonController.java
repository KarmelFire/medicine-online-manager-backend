package medicine.online.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import medicine.online.backend.common.result.Result;
import medicine.online.backend.model.vo.FileUrlVO;
import medicine.online.backend.service.CommonService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName CommonController
 * @Description TODO
 * @Author BC
 * @Date 2024/11/24 15:54
 * @Version 1.0
 */
@Tag(name = "通用模块")
@RestController
@RequestMapping("common")
@AllArgsConstructor
public class CommonController {

    private final CommonService commonService;

    @PostMapping(value = "/upload/img")
    @ResponseBody
    @Operation(summary = "图片上传")
    public Result<FileUrlVO> upload(@RequestBody MultipartFile file) {
        return Result.ok(commonService.upload(file));
    }
}
