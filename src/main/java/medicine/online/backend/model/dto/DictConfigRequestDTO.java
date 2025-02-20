package medicine.online.backend.model.dto;

import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
public class DictConfigRequestDTO {
    private Integer pkId;
    @NotBlank(message = "字典编号禁止为空")
    private String dictNumber;
    @NotBlank(message = "字典名称禁止为空")
    private String title;
    @NotNull(message = "字典值禁止为空")
    private Integer value;
}