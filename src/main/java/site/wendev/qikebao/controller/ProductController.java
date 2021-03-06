package site.wendev.qikebao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import site.wendev.qikebao.common.Response;
import site.wendev.qikebao.enums.ErrorEnum;
import site.wendev.qikebao.service.ProductService;
import site.wendev.qikebao.utils.ResponseUtil;
import site.wendev.qikebao.vo.AddProductVO;
import site.wendev.qikebao.vo.ListProductVO;
import site.wendev.qikebao.vo.SearchProductVO;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.List;

/**
 * @author 江文
 * @since 2020/11/23 8:55 下午
 */
@Validated
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public Response listProduct(ListProductVO vo) {
        return ResponseUtil.success(productService.listProduct(vo));
    }

    @GetMapping("/search")
    public Response searchProduct(SearchProductVO vo) {
        return ResponseUtil.success(productService.searchProduct(vo));
    }

    @PostMapping("/add")
    public Response addProduct(@Valid @RequestBody AddProductVO vo) {
        return ResponseUtil.success(productService.addProduct(vo));
    }

    @PostMapping("/delete")
    public Response deleteProduct(@RequestBody List<BigInteger> ids) {
        if (productService.removeByIds(ids)) {
            return ResponseUtil.success(ids);
        } else {
            return ResponseUtil.error(ErrorEnum.DELETE_ERROR, "删除产品失败，要删除的产品不存在");
        }
    }
}
