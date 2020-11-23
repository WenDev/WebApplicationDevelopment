package site.wendev.qikebao.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;
import site.wendev.qikebao.entities.Worksheet;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

/**
 * 添加工单的VO
 *
 * @author 江文
 * @since 2020/11/11 10:37 上午
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class AddWorksheetVO extends BaseVO<Worksheet> {
    /** 工单标题 */
    @NotNull(message = "添加失败：工单标题不能为空")
    @NotBlank(message = "添加失败：工单标题不能为空")
    private String title;

    /** 工单模板 */
    @NotNull(message = "添加失败：请选择工单模板")
    private BigInteger template;

    /** 关联客户 */
    private BigInteger customer;

    /** 重要度 */
    private BigInteger importance;

    /** 附件地址 */
    private String annex;

    @Override
    public Worksheet build() {
        Worksheet worksheet = new Worksheet();
        BeanUtils.copyProperties(this, worksheet);

        return worksheet;
    }
}
