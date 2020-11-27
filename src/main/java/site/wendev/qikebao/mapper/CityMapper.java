package site.wendev.qikebao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import site.wendev.qikebao.entities.City;

/**
 * 城市的Mapper
 *
 * @author 江文
 * @since 2020/11/9 8:07 下午
 * @deprecated 取消了客户系统的开发，本类不再使用
 */
@Mapper
@Repository
@Deprecated
public interface CityMapper extends BaseMapper<City> {
}
