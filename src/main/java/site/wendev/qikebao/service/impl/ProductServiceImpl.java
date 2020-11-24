package site.wendev.qikebao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.wendev.qikebao.entities.Product;
import site.wendev.qikebao.entities.Worksheet;
import site.wendev.qikebao.mapper.ProductMapper;
import site.wendev.qikebao.service.ProductService;
import site.wendev.qikebao.vo.AddProductVO;
import site.wendev.qikebao.vo.ListProductVO;
import site.wendev.qikebao.vo.PageResponse;
import site.wendev.qikebao.vo.SearchProductVO;

/**
 * 产品的服务实现类
 *
 * @author 江文
 * @since 2020/11/11 10:19 上午
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
    @Autowired
    private ProductMapper mapper;

    @Override
    public boolean addProduct(AddProductVO vo) {
        return save(vo.build());
    }

    @Override
    public PageResponse<Product> listProduct(ListProductVO vo) {
        QueryWrapper<Product> qw = new QueryWrapper<>();
        qw.eq("type", vo.getType());
        PageResponse<Product> pageResponse = new PageResponse<Product>().setPageAndSize(vo);
        pageResponse.setTotal(countProducts());
        pageResponse.setContent(
                mapper.selectPage(new Page<>(vo.getPage(), vo.getSize()), qw).getRecords());

        return pageResponse;
    }

    @Override
    public PageResponse<Product> searchProduct(SearchProductVO vo) {
        QueryWrapper<Product> qw = new QueryWrapper<>();
        qw.eq("type", vo.getType());

        if (StringUtils.isNotBlank(vo.getName())) {
            qw.like("name", vo.getName());
        }

        if (StringUtils.isNotBlank(vo.getIntroduction())) {
            qw.like("introduction", vo.getIntroduction());
        }

        PageResponse<Product> pageResponse = new PageResponse<Product>().setPageAndSize(vo);
        pageResponse.setTotal(countByQueryWrapper(qw));
        pageResponse.setContent(mapper.selectPage(new Page<>(vo.getPage(), vo.getSize()), qw).getRecords());

        return pageResponse;
    }

    private Integer countByQueryWrapper(QueryWrapper qw) {
        return count(qw);
    }

    private Integer countProducts() {
        // 查询总工单条数
        return count(null);
    }
}
