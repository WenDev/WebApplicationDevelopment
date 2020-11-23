package site.wendev.qikebao.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigInteger;

/**
 * 工单模板实体类
 *
 * @author 江文
 * @since 2020/11/9 7:50 下午
 */
@Data
@Accessors(chain = true)
@TableName("template")
@EqualsAndHashCode(callSuper = true)
public class Template extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String name;
}
