package site.wendev.qikebao.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigInteger;

/**
 * 用户实体类
 *
 * @author 江文
 * @since 2020/11/9 7:53 下午
 */
@Data
@Accessors(chain = true)
@TableName("user")
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
}
