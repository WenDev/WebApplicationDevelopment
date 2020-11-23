package site.wendev.qikebao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import site.wendev.qikebao.common.Response;
import site.wendev.qikebao.enums.ErrorEnum;
import site.wendev.qikebao.service.WorksheetService;
import site.wendev.qikebao.utils.ResponseUtil;
import site.wendev.qikebao.vo.AddWorksheetVO;
import site.wendev.qikebao.vo.ListWorksheetVO;
import site.wendev.qikebao.vo.SearchWorksheetVO;

import javax.validation.Valid;
import java.math.BigInteger;

/**
 * 工单的Controller
 *
 * @author 江文
 * @since 2020/11/11 10:41 上午
 */
@Validated
@RestController
@RequestMapping("/worksheet")
public class WorksheetController {
    @Autowired
    private WorksheetService worksheetService;

    @GetMapping("/list")
    public Response listWorksheet(ListWorksheetVO vo) {
        return ResponseUtil.success(worksheetService.listWorksheet(vo));
    }

    @GetMapping("/search")
    public Response searchWorksheet(SearchWorksheetVO vo) {
        return ResponseUtil.success(worksheetService.searchWorksheet(vo));
    }

    @PostMapping("/add")
    public Response addWorksheet(@Valid @RequestBody AddWorksheetVO vo) {
        if (worksheetService.addWorksheet(vo)) {
            return ResponseUtil.success(vo.build());
        } else {
            return ResponseUtil.error(ErrorEnum.ADD_ERROR, "添加工单失败");
        }
    }

    @DeleteMapping("/delete")
    public Response deleteWorksheet(BigInteger id) {
        if (worksheetService.removeById(id)) {
            return ResponseUtil.success(id);
        } else {
            return ResponseUtil.error(ErrorEnum.DELETE_ERROR, "删除工单失败，该工单不存在");
        }
    }
}
