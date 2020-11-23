package site.wendev.qikebao.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 产品表
 *
 * @author 江文
 * @since 2020/11/9 7:46 下午
 */
@Data
@Accessors(chain = true)
@TableName("product")
@EqualsAndHashCode(callSuper = true)
public class Product extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String name;
    private String number;
    private BigInteger type;
    private String unit;
    private BigDecimal price;
    private BigDecimal cost;
    private String introduction;
}
