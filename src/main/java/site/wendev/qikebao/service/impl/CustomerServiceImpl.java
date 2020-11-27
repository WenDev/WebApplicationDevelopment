package site.wendev.qikebao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import site.wendev.qikebao.entities.Customer;
import site.wendev.qikebao.mapper.CustomerMapper;
import site.wendev.qikebao.service.CustomerService;

/**
 * 客户服务的实现类
 *
 * @author 江文
 * @since 2020/11/11 10:17 上午
 * @deprecated 取消了客户系统的开发，本类不再使用
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {
}
