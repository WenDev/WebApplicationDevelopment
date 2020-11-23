package site.wendev.qikebao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import site.wendev.qikebao.entities.Product;
import site.wendev.qikebao.vo.AddProductVO;
import site.wendev.qikebao.vo.ListProductVO;
import site.wendev.qikebao.vo.PageResponse;
import site.wendev.qikebao.vo.SearchProductVO;

/**
 * 产品的Service接口
 *
 * @author 江文
 * @since 2020/11/10 10:18 下午
 */
public interface ProductService extends IService<Product> {
    boolean addProduct(AddProductVO vo);
    PageResponse<Product> listProduct(ListProductVO vo);
    PageResponse<Product> searchProduct(SearchProductVO vo);
}
