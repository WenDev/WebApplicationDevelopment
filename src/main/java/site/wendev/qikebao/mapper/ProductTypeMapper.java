package site.wendev.qikebao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import site.wendev.qikebao.entities.ProductType;

/**
 * 产品类型的Mapper
 *
 * @author 江文
 * @since 2020/11/9 8:10 下午
 */
@Mapper
@Repository
public interface ProductTypeMapper extends BaseMapper<ProductType> {
}
