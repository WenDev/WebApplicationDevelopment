package site.wendev.qikebao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.wendev.qikebao.common.Response;
import site.wendev.qikebao.service.ProductTypeService;
import site.wendev.qikebao.utils.ResponseUtil;

/**
 * @author 江文
 * @since 2020/11/23 7:52 下午
 */
@Validated
@RestController
@RequestMapping("/productType")
public class ProductTypeController {
    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping("/tree")
    public Response listProductTypesTree() {
        return ResponseUtil.success(productTypeService.listProductTypes());
    }

    @GetMapping("/list")
    public Response listProductTypes() {
        return ResponseUtil.success(productTypeService.list());
    }
}
