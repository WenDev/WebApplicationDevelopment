package site.wendev.qikebao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import site.wendev.qikebao.entities.Province;
import site.wendev.qikebao.mapper.ProvinceMapper;
import site.wendev.qikebao.service.ProvinceService;

/**
 * 省份服务的实现类
 *
 * @author 江文
 * @since 2020/11/11 10:22 上午
 * @deprecated 取消了客户系统的开发，本类不再使用
 */
@Service
@Deprecated
public class ProvinceServiceImpl extends ServiceImpl<ProvinceMapper, Province> implements ProvinceService {
}
