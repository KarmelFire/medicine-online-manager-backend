package medicine.online.backend.controller;

import medicine.online.backend.common.result.Result;
import medicine.online.backend.security.utils.TokenUtils;
import medicine.online.backend.service.AuthService;
import medicine.online.backend.service.SysCaptchaService;
import medicine.online.backend.model.vo.SysAccountLoginVO;
import medicine.online.backend.model.vo.SysCaptchaVO;
import medicine.online.backend.model.vo.SysTokenVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "认证管理")
@RestController
@RequestMapping("sys/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    private final SysCaptchaService sysCaptchaService;

    @PostMapping("login")
    @Operation(summary = "账号密码登录")
    public Result<SysTokenVO> login(@RequestBody SysAccountLoginVO login) {
        return Result.ok(authService.loginByAccount(login));
    }

    @PostMapping("captcha")
    @Operation(summary = "图片验证码")
    public Result<SysCaptchaVO> captcha() {
        SysCaptchaVO captchaVO = sysCaptchaService.generate();

        return Result.ok(captchaVO);
    }

    @PostMapping("logout")
    @Operation(summary = "退出")
    public Result<String> logout(HttpServletRequest request) {
        authService.logout(TokenUtils.getAccessToken(request));

        return Result.ok();
    }

}
