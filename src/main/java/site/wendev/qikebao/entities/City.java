package site.wendev.qikebao.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigInteger;

/**
 * 城市实体类
 *
 * @author 江文
 * @since 2020/11/4 7:42 下午
 * @deprecated 取消了客户系统的开发，本类不再使用
 */
@Data
@Deprecated
@Accessors(chain = true)
@TableName("city")
@EqualsAndHashCode(callSuper = true)
public class City extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String name;
    private BigInteger province;
}
