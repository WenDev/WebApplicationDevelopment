package site.wendev.qikebao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.wendev.qikebao.common.Response;
import site.wendev.qikebao.service.ImportanceService;
import site.wendev.qikebao.utils.ResponseUtil;

/**
 * 工单重要性的Controller
 *
 * @author 江文
 * @since 2020/11/19 11:17 上午
 */
@RestController
@RequestMapping("/importance")
public class ImportanceController {
    @Autowired
    private ImportanceService importanceService;

    @GetMapping("/list")
    public Response listWorksheets() {
        return ResponseUtil.success(importanceService.list());
    }
}
