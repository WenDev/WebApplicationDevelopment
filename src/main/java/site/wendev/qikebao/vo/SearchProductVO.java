package site.wendev.qikebao.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigInteger;

/**
 * @author 江文
 * @since 2020/11/23 9:01 下午
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class SearchProductVO extends BasePageVO<SearchProductVO> {
    private String name;
    private String introduction;
    private BigInteger type;
}
