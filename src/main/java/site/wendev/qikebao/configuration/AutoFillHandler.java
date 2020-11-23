package site.wendev.qikebao.configuration;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import site.wendev.qikebao.entities.User;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * MyBatisPlus自动填充配置
 *
 * @author 江文
 * @since 2020/11/10 7:02 下午
 */
@Component
public class AutoFillHandler implements MetaObjectHandler {
    @Autowired
    private HttpSession session;

    @Override
    public void insertFill(MetaObject metaObject) {
        // 插入时自动填充
        // 获得Session中存放的当前用户对象
        User user = (User) session.getAttribute("user");
        Date date = new Date();

        // 创建时间和更新时间填入当前时间
        this.setFieldValByName("createdTime", date, metaObject);
        this.setFieldValByName("updatedTime", date, metaObject);
        // 创建人和更新人填入从Session中获得的当前用户的用户名
        this.setFieldValByName("createdBy", user.getUsername(), metaObject);
        this.setFieldValByName("updatedBy", user.getUsername(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 更新时自动填充
        User user = (User) session.getAttribute("user");
        Date date = new Date();

        // 更新时间填入当前时间
        this.setFieldValByName("updatedTime", date, metaObject);
        // 更新人填入Session中获得的当前用户id
        this.setFieldValByName("updatedBy", user.getUsername(), metaObject);
    }
}
