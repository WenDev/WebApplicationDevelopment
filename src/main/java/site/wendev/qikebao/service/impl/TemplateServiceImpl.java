package site.wendev.qikebao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import site.wendev.qikebao.entities.Template;
import site.wendev.qikebao.mapper.TemplateMapper;
import site.wendev.qikebao.service.TemplateService;

/**
 * 工单模板的服务实现类
 *
 * @author 江文
 * @since 2020/11/11 10:22 上午
 */
@Service
public class TemplateServiceImpl extends ServiceImpl<TemplateMapper, Template> implements TemplateService {
}
