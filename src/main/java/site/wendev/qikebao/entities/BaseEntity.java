package site.wendev.qikebao.entities;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

/**
 * 实体类的基类，定义了公共属性
 *
 * @author 江文
 * @since 2020/11/10 7:17 下午
 */
@Data
public class BaseEntity implements Serializable {
    /** 主键，使用自增id */
    @TableId(type = IdType.AUTO)
    private BigInteger id;

    /** 创建人 */
    @TableField(value = "created_by", fill = FieldFill.INSERT)
    private String createdBy;

    /** 更新人 */
    @TableField(value = "updated_by", fill = FieldFill.INSERT_UPDATE)
    private String updatedBy;

    /** 创建时间 */
    @TableField(value = "created_time", fill = FieldFill.INSERT)
    private Date createdTime;

    /** 更新时间 */
    @TableField(value = "updated_time", fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    /** 逻辑删除 */
    @TableLogic(delval = "1", value = "0")
    private Integer flag = 0;
}
