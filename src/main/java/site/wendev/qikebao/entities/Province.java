package site.wendev.qikebao.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigInteger;

/**
 * 省份实体类
 *
 * @author 江文
 * @since 2020/11/9 7:49 下午
 */
@Data
@Accessors(chain = true)
@TableName("province")
@EqualsAndHashCode(callSuper = true)
public class Province extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String name;
}
