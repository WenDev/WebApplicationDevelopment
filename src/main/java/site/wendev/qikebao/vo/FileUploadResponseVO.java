package site.wendev.qikebao.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 文件上传返回信息
 *
 * @author 江文
 * @since 2020/11/22 9:24 下午
 */
@Data
@Accessors(chain = true)
public class FileUploadResponseVO {
    /** 文件原名 */
    private String originalFileName;
    /** 文件路径 */
    private String filePath;
}
