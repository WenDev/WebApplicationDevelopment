package site.wendev.qikebao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import site.wendev.qikebao.entities.Worksheet;
import site.wendev.qikebao.vo.AddWorksheetVO;
import site.wendev.qikebao.vo.ListWorksheetVO;
import site.wendev.qikebao.vo.PageResponse;
import site.wendev.qikebao.vo.SearchWorksheetVO;

/**
 * 工单的Service接口
 *
 * @author 江文
 * @since 2020/11/10 11:07 下午
 */
public interface WorksheetService extends IService<Worksheet> {
    PageResponse<Worksheet> listWorksheet(ListWorksheetVO vo);
    boolean addWorksheet(AddWorksheetVO vo);
    PageResponse<Worksheet> searchWorksheet(SearchWorksheetVO vo);
}
