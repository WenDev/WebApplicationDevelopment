package site.wendev.qikebao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.wendev.qikebao.entities.ProductType;
import site.wendev.qikebao.mapper.ProductTypeMapper;
import site.wendev.qikebao.service.ProductTypeService;
import site.wendev.qikebao.vo.AddProductTypeVO;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 产品服务实现类
 *
 * @author 江文
 * @since 2020/11/11 10:20 上午
 */
@Service
public class ProductTypeServiceImpl extends ServiceImpl<ProductTypeMapper, ProductType> implements ProductTypeService {
    @Autowired
    private ProductTypeMapper mapper;

    @Override
    public List<ProductType> listProductTypes() {
        List<ProductType> tree = new ArrayList<>();
        List<ProductType> allProductTypes = mapper.selectList(null);
        Map<BigInteger, ProductType> map = new HashMap<>();
        for (ProductType productType : allProductTypes) {
            map.put(productType.getId(), productType);
        }

        for (ProductType productType : allProductTypes) {
            ProductType parent = mapper.selectById(productType.getPid());
            if (parent != null) {
                parent = map.get(productType.getPid());
                parent.addChildren(productType);
            } else {
                tree.add(productType);
            }
        }

        return tree;
    }

    @Override
    public boolean addProductType(AddProductTypeVO vo) {
        return save(vo.build());
    }
}
