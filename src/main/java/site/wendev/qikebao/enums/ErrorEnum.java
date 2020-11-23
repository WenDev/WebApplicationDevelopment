package site.wendev.qikebao.enums;

import lombok.Getter;

/**
 * 错误码枚举类
 *
 * @author 江文
 * @since 2020/10/29 8:06 下午
 */
@Getter
public enum ErrorEnum {
    // 没有登录
    AUTH_FAILURE(-2),
    // 参数校验失败
    CHECK_FAILURE(-1),
    // 添加数据失败
    ADD_ERROR(1),
    // 更新数据失败
    UPDATE_ERROR(2),
    // 查找数据失败
    GET_ERROR(3),
    // 删除失败
    DELETE_ERROR(4),
    // 未知异常
    UNKNOWN_EXCEPTION(99);

    private final Integer code;

    ErrorEnum(Integer code) {
        this.code = code;
    }

    /**
     * 根据错误码拿到对应的枚举对象
     *
     * @param code 错误码
     * @return 错误码对应的枚举对象，找不到则返回null
     */
    public static ErrorEnum getByCode(int code){
        for (ErrorEnum resultEnum : ErrorEnum.values()) {
            if(code == resultEnum.getCode()){
                return resultEnum;
            }
        }
        return null;
    }
}
