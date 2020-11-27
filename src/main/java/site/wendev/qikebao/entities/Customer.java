package site.wendev.qikebao.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigInteger;
import java.util.Date;

/**
 * @author 江文
 * @since 2020/11/4 7:48 下午
 * @deprecated 取消了客户系统的开发，本类不再使用
 */
@Data
@Deprecated
@Accessors(chain = true)
@TableName("customer")
@EqualsAndHashCode(callSuper = true)
public class Customer extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String name;
    private BigInteger label;
    private BigInteger principal;
    private BigInteger type;
    private BigInteger province;
    private BigInteger city;
    private Date connectTime;
    private Date distributionTime;
    private Date lastConnectedTime;
    private BigInteger lastConnectedId;
}
