package site.wendev.qikebao.utils;

import site.wendev.qikebao.common.Response;
import site.wendev.qikebao.enums.ErrorEnum;

/**
 * 统一返回对象的统一创建操作
 *
 * @author 江文
 * @since 2020/10/29 8:20 下午
 */
public class ResponseUtil {
    public static Response success(Object data) {
        // 操作成功，返回的错误码是0并返回对应数据
        return new Response().setCode(0).setMessage("操作成功").setData(data);
    }

    public static Response error(ErrorEnum err, String message) {
        // 操作失败，返回对应的错误信息和空数据
        return new Response().setCode(err.getCode()).setMessage(message).setData(null);
    }
}
