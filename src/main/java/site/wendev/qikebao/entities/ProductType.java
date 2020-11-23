package site.wendev.qikebao.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 产品类型实体类
 *
 * @author 江文
 * @since 2020/11/9 7:48 下午
 */
@Data
@Accessors(chain = true)
@TableName("product_type")
@EqualsAndHashCode(callSuper = true)
public class ProductType extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String name;
    private BigInteger pid;

    @TableField(exist = false)
    private List<ProductType> children = new ArrayList<>();

    public ProductType addChildren(ProductType productType) {
        this.children.add(productType);
        return this;
    }
}
