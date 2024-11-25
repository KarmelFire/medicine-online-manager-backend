package medicine.online.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.backend.common.result.PageResult;
import medicine.online.backend.model.dto.DictRequestDTO;
import medicine.online.backend.model.entity.Dict;
import medicine.online.backend.model.query.DictQuery;

import java.util.List;

public interface DictService extends IService<Dict> {

    /**
     * 字典列表 -分页
     *
     * @param query
     * @return
     */
    PageResult<Dict> getPage(DictQuery query);

    void refreshTransCache();

    /**
     * 新增字典
     *
     * @param dto
     */
    void add(DictRequestDTO dto);

    /**
     * 修改字典
     *
     * @param dto
     */
    void edit(DictRequestDTO dto);

    /**
     * 删除字典
     *
     * @param ids
     */
    void remove(List<Integer> ids);

    /**
     * 根据字典编号查询
     * @param number
     * @return
     */
    boolean existByNumber(String number);
}
