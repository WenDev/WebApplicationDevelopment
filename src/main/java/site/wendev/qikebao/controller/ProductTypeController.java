package site.wendev.qikebao.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import site.wendev.qikebao.common.Response;
import site.wendev.qikebao.entities.Product;
import site.wendev.qikebao.entities.ProductType;
import site.wendev.qikebao.enums.ErrorEnum;
import site.wendev.qikebao.service.ProductService;
import site.wendev.qikebao.service.ProductTypeService;
import site.wendev.qikebao.utils.ResponseUtil;
import site.wendev.qikebao.vo.AddProductTypeVO;

import java.math.BigInteger;

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

    @Autowired
    private ProductService productService;

    @GetMapping("/tree")
    public Response listProductTypesTree() {
        return ResponseUtil.success(productTypeService.listProductTypes());
    }

    @GetMapping("/list")
    public Response listProductTypes() {
        return ResponseUtil.success(productTypeService.list());
    }

    @PostMapping("/add")
    public Response addProductType(@RequestBody AddProductTypeVO vo) {
        return ResponseUtil.success(productTypeService.addProductType(vo));
    }

    @DeleteMapping("/delete")
    public Response deleteProductType(BigInteger id) {
        ProductType productType = productTypeService.getById(id);
        if (productType == null) {
            return ResponseUtil.error(ErrorEnum.DELETE_ERROR, "删除产品类型失败：该产品类型不存在");
        }

        if (productService.getOne(new QueryWrapper<Product>().eq("type", productType.getId())) != null) {
            return ResponseUtil.error(ErrorEnum.DELETE_ERROR, "删除产品类型失败：请先删除该产品分类下的所有产品再删除该分类");
        }

        if (productTypeService.removeById(id)) {
            return ResponseUtil.success(id);
        } else {
            return ResponseUtil.error(ErrorEnum.DELETE_ERROR, "删除产品类型失败：该产品类型不存在");
        }
    }
}
