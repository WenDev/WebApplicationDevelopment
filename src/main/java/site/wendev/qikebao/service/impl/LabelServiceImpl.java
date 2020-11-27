package site.wendev.qikebao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import site.wendev.qikebao.entities.Label;
import site.wendev.qikebao.mapper.LabelMapper;
import site.wendev.qikebao.service.LabelService;

/**
 * 标签服务的实现类
 *
 * @author 江文
 * @since 2020/11/11 10:18 上午
 * @deprecated 取消了客户系统的开发，本类不再使用
 */
@Service
@Deprecated
public class LabelServiceImpl extends ServiceImpl<LabelMapper, Label> implements LabelService {
}
