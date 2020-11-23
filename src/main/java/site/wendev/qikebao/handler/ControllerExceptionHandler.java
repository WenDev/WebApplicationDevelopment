package site.wendev.qikebao.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import site.wendev.qikebao.common.Response;
import site.wendev.qikebao.enums.ErrorEnum;
import site.wendev.qikebao.utils.ResponseUtil;

/**
 * @author 江文
 * @since 2020/10/29 8:44 下午
 */
@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(BindException.class)
    public Response handleBindException(BindException e) {
        // 表单提交异常：数据校验不通过，返回错误信息
        return ResponseUtil.error(ErrorEnum.ADD_ERROR, e.getFieldErrors().iterator().next().getDefaultMessage());
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    public Response exception(Exception e) {
        e.printStackTrace();
        return ResponseUtil.error(ErrorEnum.UNKNOWN_EXCEPTION, e.getMessage());
    }
}
