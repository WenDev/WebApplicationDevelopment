package site.wendev.qikebao.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author 江文
 * @since 2020/11/23 8:59 下午
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class ListProductVO extends BasePageVO<ListProductVO> {
}
