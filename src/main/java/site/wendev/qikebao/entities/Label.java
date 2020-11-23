package site.wendev.qikebao.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 客户标签实体类
 *
 * @author 江文
 * @since 2020/11/9 7:45 下午
 */
@Data
@Accessors(chain = true)
@TableName("label")
@EqualsAndHashCode(callSuper = true)
public class Label extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String name;
}