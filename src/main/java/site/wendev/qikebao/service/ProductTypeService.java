package site.wendev.qikebao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import site.wendev.qikebao.entities.ProductType;

import java.util.List;

/**
 * 产品类型的Service
 *
 * @author 江文
 * @since 2020/11/10 10:38 下午
 */
public interface ProductTypeService extends IService<ProductType> {
    List<ProductType> listProductTypes();
}
