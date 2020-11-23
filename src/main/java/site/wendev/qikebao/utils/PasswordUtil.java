package site.wendev.qikebao.utils;

import org.mindrot.jbcrypt.BCrypt;

/**
 * 密码相关工具类
 *
 * @author 江文
 * @since 2020/11/18 7:14 下午
 */
public class PasswordUtil {
    /**
     * 对明文密码进行加密
     *
     * @param plantPassword 要加密的明文密码
     * @return 加密完成后的密码
     */
    public static String encode(String plantPassword) {
        // 对密码进行加密
        // gensalt()表示加盐操作，使用BCrypt自带的gensalt()方法进行加盐
        return BCrypt.hashpw(plantPassword, BCrypt.gensalt());
    }

    /**
     * 检查明文密码和加密密码是否相等
     *
     * @param plantPassword 明文密码
     * @param encodedPassword 加密后的密码
     * @return 校验结果：相等返回true，不相等返回false
     */
    public static boolean check(String plantPassword, String encodedPassword) {
        // 使用BCrypt自带的checkpw()方法检查明文密码与加密后的密码是否相等
        return BCrypt.checkpw(plantPassword, encodedPassword);
    }
}
