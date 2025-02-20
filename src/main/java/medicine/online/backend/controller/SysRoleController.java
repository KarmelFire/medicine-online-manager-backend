package medicine.online.backend.controller;

import medicine.online.backend.common.result.PageResult;
import medicine.online.backend.common.result.Result;
import medicine.online.backend.model.query.SysRoleQuery;
import medicine.online.backend.service.SysMenuService;
import medicine.online.backend.service.SysRoleService;
import medicine.online.backend.model.vo.SysMenuVO;
import medicine.online.backend.model.vo.SysRoleVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import java.util.List;

@Tag(name = "角色管理")
@AllArgsConstructor
@RestController
@RequestMapping("/sys/role")
public class SysRoleController {

    private SysRoleService sysRoleService;

    private SysMenuService sysMenuService;

    @PostMapping("page")
    @Operation(summary = "分页")
    public Result<PageResult<SysRoleVO>> page(@RequestBody @Valid SysRoleQuery query) {
        PageResult<SysRoleVO> page = sysRoleService.page(query);
        return Result.ok(page);
    }

    @PostMapping("list")
    @Operation(summary = "列表")
    public Result<List<SysRoleVO>> list() {
        List<SysRoleVO> list = sysRoleService.getList(new SysRoleQuery());
        return Result.ok(list);
    }

    @PostMapping("add")
    @Operation(summary = "保存")
    public Result<String> save(@RequestBody @Valid SysRoleVO vo) {
        sysRoleService.save(vo);
        return Result.ok();
    }

    @PostMapping("edit")
    @Operation(summary = "修改")
    public Result<String> update(@RequestBody @Valid SysRoleVO vo) {
        sysRoleService.update(vo);
        return Result.ok();
    }

    @PostMapping("remove")
    @Operation(summary = "删除")
    public Result<String> delete(@RequestBody List<Integer> idList) {
        sysRoleService.delete(idList);
        return Result.ok();
    }

    @PostMapping("menu")
    @Operation(summary = "角色表单菜单列表")
    public Result<List<SysMenuVO>> getRoleFormMenuList() {
        List<SysMenuVO> list = sysMenuService.getRoleFormMenuList();
        return Result.ok(list);
    }

}
