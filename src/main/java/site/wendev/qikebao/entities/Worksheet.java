package site.wendev.qikebao.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigInteger;

/**
 * 工单实体类
 *
 * @author 江文
 * @since 2020/11/9 7:54 下午
 */
@Data
@Accessors(chain = true)
@TableName("worksheet")
@EqualsAndHashCode(callSuper = true)
public class Worksheet extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String title;
    private BigInteger template;
    private BigInteger customer;
    private BigInteger importance;
    private String annex;
}
