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
 */
@Mapper
@Repository
public interface CityMapper extends BaseMapper<City> {
}
