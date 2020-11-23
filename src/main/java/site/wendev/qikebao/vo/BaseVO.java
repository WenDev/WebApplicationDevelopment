package site.wendev.qikebao.vo;

import lombok.Data;

/**
 * VO基类
 *
 * @author 江文
 * @since 2020/10/29 7:51 下午
 */
@Data
public abstract class BaseVO<T> {
    /**
     * 根据VO构建实体对象
     *
     * @return 构建完成的实体对象
     */
    public abstract T build();
}
