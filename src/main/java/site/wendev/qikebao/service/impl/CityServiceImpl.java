package site.wendev.qikebao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import site.wendev.qikebao.entities.City;
import site.wendev.qikebao.mapper.CityMapper;
import site.wendev.qikebao.service.CityService;

/**
 * 城市的服务实现类
 *
 * @author 江文
 * @since 2020/11/11 10:15 上午
 * @deprecated 取消了客户系统的开发，本类不再使用
 */
@Service
@Deprecated
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements CityService {
}
