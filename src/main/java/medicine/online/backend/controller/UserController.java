package medicine.online.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import medicine.online.backend.common.result.PageResult;
import medicine.online.backend.common.result.Result;
import medicine.online.backend.model.dto.UserEditDTO;
import medicine.online.backend.model.query.UserQuery;
import medicine.online.backend.model.vo.UserInfoVO;
import medicine.online.backend.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author BC
 * @Date 2024/11/24 18:07
 * @Version 1.0
 */
@RestController
@AllArgsConstructor
@Tag(name = "用户管理", description = "用户管理")
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('sys:user:view')")
    public Result<PageResult<UserInfoVO>> page(@RequestBody @Valid UserQuery query) {
        return Result.ok(userService.page(query));
    }
    @PostMapping("edit")
    @Operation(summary = "修改 ")
    @PreAuthorize("hasAuthority('sys:user:edit')")
    public Result<String> update(@RequestBody @Valid UserEditDTO dto) {
        userService.update(dto);
        return Result.ok();
    }
    @PostMapping("export")
    @Operation(summary = "导出")
    @PreAuthorize("hasAuthority('sys:user:export')")
    public void export(@RequestBody UserQuery query, HttpServletResponse response) {
        userService.export(query, response);
    }
    @PostMapping("enabled")
    @Operation(summary = "账户状态修改")
    @PreAuthorize("hasAuthority('sys:user:freeze')")
    public Result<String> enabled(@RequestParam Integer userId) {
        userService.enabled(userId);
        return Result.ok();
    }


}

