package site.wendev.qikebao.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 自定异常
 *
 * @author 江文
 * @since 2020/10/29 8:04 下午
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BusinessException extends RuntimeException {
    /** 错误码 */
    private final Integer code;
    /** 发生异常的方法 */
    private final String method;

    public BusinessException(Integer code, String message, String method) {
        super(message);
        this.code = code;
        this.method = method;
    }
}
