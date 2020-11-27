package site.wendev.qikebao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import site.wendev.qikebao.entities.Type;

/**
 * 客户类型的Mapper
 *
 * @author 江文
 * @since 2020/11/9 8:04 下午
 * @deprecated 取消了客户系统的开发，本类不再使用
 */
@Mapper
@Repository
@Deprecated
public interface TypeMapper extends BaseMapper<Type> {
}
