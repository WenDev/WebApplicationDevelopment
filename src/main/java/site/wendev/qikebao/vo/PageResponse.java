package site.wendev.qikebao.vo;

import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * 分页返回对象
 *
 * @author 江文
 * @since 2020/10/29 8:30 下午
 */
@Data
public class PageResponse<T> {
    /** 本页的数据 */
    private List<T> content;
    /** 一共多少数据 */
    private Integer total;
    /** 一共多少页 */
    private Integer totalPages;
    /** 当前是第几页 */
    private Integer page;
    /** 每页多少数据 */
    private Integer size;

    public PageResponse<T> setPageAndSize(BasePageVO<?> vo) {
        BeanUtils.copyProperties(vo, this);
        return this;
    }

    public void setTotal(Integer total) {
        this.total = total;
        this.setTotalPages(this.total % this.size > 0 ? this.total / this.size + 1 : this.total / this.size);
    }
}
