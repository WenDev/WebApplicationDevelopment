package site.wendev.qikebao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.wendev.qikebao.common.Response;
import site.wendev.qikebao.service.TemplateService;
import site.wendev.qikebao.utils.ResponseUtil;

/**
 * @author 江文
 * @since 2020/11/19 11:40 上午
 */
@RestController
@RequestMapping("/template")
public class TemplateController {
    @Autowired
    private TemplateService templateService;

    @GetMapping("/list")
    public Response listTemplates() {
        return ResponseUtil.success(templateService.list());
    }
}
