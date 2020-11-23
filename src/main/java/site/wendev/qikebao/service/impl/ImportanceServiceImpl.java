package site.wendev.qikebao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import site.wendev.qikebao.entities.Importance;
import site.wendev.qikebao.mapper.ImportanceMapper;
import site.wendev.qikebao.service.ImportanceService;

/**
 * 工单重要性的服务实现类
 *
 * @author 江文
 * @since 2020/11/11 10:17 上午
 */
@Service
public class ImportanceServiceImpl extends ServiceImpl<ImportanceMapper, Importance> implements ImportanceService {
}
