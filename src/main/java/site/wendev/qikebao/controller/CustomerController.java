package site.wendev.qikebao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.wendev.qikebao.common.Response;
import site.wendev.qikebao.service.CustomerService;
import site.wendev.qikebao.utils.ResponseUtil;

/**
 * 客户的Controller
 *
 * @author 江文
 * @since 2020/11/22 8:57 下午
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public Response listCustomer() {
        return ResponseUtil.success(customerService.list());
    }
}
