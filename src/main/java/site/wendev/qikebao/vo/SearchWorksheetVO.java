package site.wendev.qikebao.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author 江文
 * @since 2020/11/23 5:27 下午
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class SearchWorksheetVO extends BasePageVO<SearchWorksheetVO> {
    private String title;
    private String startTime;
    private String endTime;
}
