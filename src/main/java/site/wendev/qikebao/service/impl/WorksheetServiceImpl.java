package site.wendev.qikebao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.wendev.qikebao.entities.Worksheet;
import site.wendev.qikebao.mapper.WorksheetMapper;
import site.wendev.qikebao.service.WorksheetService;
import site.wendev.qikebao.vo.AddWorksheetVO;
import site.wendev.qikebao.vo.ListWorksheetVO;
import site.wendev.qikebao.vo.PageResponse;
import site.wendev.qikebao.vo.SearchWorksheetVO;

/**
 * 工单服务实现类
 *
 * @author 江文
 * @since 2020/11/11 10:24 上午
 */
@Service
public class WorksheetServiceImpl extends ServiceImpl<WorksheetMapper, Worksheet> implements WorksheetService {
    @Autowired
    private WorksheetMapper mapper;

    @Override
    public PageResponse<Worksheet> listWorksheet(ListWorksheetVO vo) {
        PageResponse<Worksheet> pageResponse = new PageResponse<Worksheet>().setPageAndSize(vo);
        pageResponse.setTotal(countWorksheets());
        pageResponse.setContent(
                mapper.selectPage(new Page<>(vo.getPage(), vo.getSize()), null).getRecords());

        return pageResponse;
    }

    @Override
    public PageResponse<Worksheet> searchWorksheet(SearchWorksheetVO vo) {
        QueryWrapper<Worksheet> qw = new QueryWrapper<>();
        if (StringUtils.isNotBlank(vo.getTitle())) {
            qw.like("title", vo.getTitle());
        }

        if (StringUtils.isNotBlank(vo.getStartTime())) {
            qw.ge("created_time", vo.getStartTime());
        }

        if (StringUtils.isNotBlank(vo.getEndTime())) {
            qw.le("created_time", vo.getEndTime());
        }

        PageResponse<Worksheet> pageResponse = new PageResponse<Worksheet>().setPageAndSize(vo);
        pageResponse.setTotal(countByQueryWrapper(qw));
        pageResponse.setContent(mapper.selectPage(new Page<>(vo.getPage(), vo.getSize()), qw).getRecords());

        return pageResponse;
    }

    @Override
    public boolean addWorksheet(AddWorksheetVO vo) {
        return save(vo.build());
    }

    private Integer countByQueryWrapper(QueryWrapper qw) {
        return count(qw);
    }

    private Integer countWorksheets() {
        // 查询总工单条数
        return count(null);
    }
}
