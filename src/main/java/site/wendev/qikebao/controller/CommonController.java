package site.wendev.qikebao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 江文
 * @since 2020/11/19 11:03 上午
 */
@Controller
public class CommonController {
    @GetMapping("/worksheet")
    public String worksheetPage() {
        return "worksheet";
    }

    @GetMapping("/workbench")
    public String workbenchPage() {
        return "workbench";
    }

    @GetMapping("/product")
    public String productPage() {
        return "product";
    }
}
