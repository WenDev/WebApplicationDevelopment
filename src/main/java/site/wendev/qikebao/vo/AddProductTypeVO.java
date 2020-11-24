package site.wendev.qikebao.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;
import site.wendev.qikebao.entities.ProductType;

import javax.validation.constraints.NotBlank;
import java.math.BigInteger;

/**
 * @author 江文
 * @since 2020/11/24 10:44 下午
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AddProductTypeVO extends BaseVO<ProductType> {
    @NotBlank(message = "添加失败：产品分类名称不能为空")
    private String name;
    private BigInteger pid;

    @Override
    public ProductType build() {
        ProductType productType = new ProductType();
        BeanUtils.copyProperties(this, productType);
        return productType;
    }
}
