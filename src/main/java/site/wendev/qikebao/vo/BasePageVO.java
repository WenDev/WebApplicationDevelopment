package site.wendev.qikebao.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;

/**
 * 进行分页查询所用的VO基类，实际分页查询的VO继承这个类
 *
 * @author 江文
 * @since 2020/10/29 8:33 下午
 */
@Data
public class BasePageVO<T extends BasePageVO<?>> {
    @Min(value = 1, message = "查找失败：当前页码必须大于1")
    private Integer page;

    @Range(min = 1, max = 50, message = "查找失败：每页数据条数必须在1-50条之间")
    private Integer size;

    public T calcCurrentPage() {
        this.page = (this.page - 1) * size;
        return (T) this;
    }
}
