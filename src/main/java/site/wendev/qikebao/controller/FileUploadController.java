package site.wendev.qikebao.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import site.wendev.qikebao.common.Response;
import site.wendev.qikebao.utils.ResponseUtil;
import site.wendev.qikebao.vo.FileUploadResponseVO;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传的Controller
 *
 * @author 江文
 * @since 2020/11/22 9:12 下午
 */
@RestController
@RequestMapping("/file")
public class FileUploadController {
    @Value("${file.location}")
    private String filePath;

    @PostMapping("/upload")
    public Response uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        File path = new File(filePath);
        if (!path.exists()) {
            path.mkdirs();
        }

        String originalName = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString().replace("-", "") + "_" + originalName;
        File destFile = new File(path + "/" + fileName);

        file.transferTo(destFile);

        return ResponseUtil.success(new FileUploadResponseVO()
                .setOriginalFileName(originalName)
                .setFilePath("/file/" + fileName));
    }
}
