package site.wendev.qikebao.common;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 江文
 * @since 2020/10/28 8:52 下午
 */
@Data
@Accessors(chain = true)
public class Response {
    /** 错误码，为0则成功 */
    private Integer code;

    /** 提示信息 */
    private String message;

    /** 返回数据 */
    private Object data;
}
