package site.wendev.qikebao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import site.wendev.qikebao.entities.Type;
import site.wendev.qikebao.mapper.TypeMapper;
import site.wendev.qikebao.service.TypeService;

/**
 * 类型服务的实现类
 *
 * @author 江文
 * @since 2020/11/11 10:23 上午
 * @deprecated 取消了客户系统的开发，本类不再使用
 */
@Service
@Deprecated
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {
}
