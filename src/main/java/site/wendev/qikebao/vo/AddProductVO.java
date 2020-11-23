package site.wendev.qikebao.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;
import site.wendev.qikebao.entities.Product;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 添加产品的VO
 *
 * @author 江文
 * @since 2020/11/23 8:47 下午
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class AddProductVO extends BaseVO<Product> {
    @NotBlank(message = "添加失败：产品名称不能为空")
    private String name;

    @NotBlank(message = "添加失败：产品编号不能为空")
    private String number;
    private BigInteger type;

    @NotBlank(message = "添加失败：产品单位不能为空")
    private String unit;

    @NotBlank(message = "添加失败：产品售价不能为空")
    private BigDecimal price;
    private BigDecimal cost;
    private String introduction;

    @Override
    public Product build() {
        Product product = new Product();
        BeanUtils.copyProperties(this, product);

        return product;
    }
}
