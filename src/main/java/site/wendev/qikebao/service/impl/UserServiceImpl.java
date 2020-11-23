package site.wendev.qikebao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.wendev.qikebao.entities.User;
import site.wendev.qikebao.mapper.UserMapper;
import site.wendev.qikebao.service.UserService;
import site.wendev.qikebao.utils.PasswordUtil;

/**
 * 用户服务的实现类
 *
 * @author 江文
 * @since 2020/11/11 10:24 上午
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("username", username);
        User user = userMapper.selectOne(qw);

        // 用户存在且密码正确
        if (user != null && PasswordUtil.check(password, user.getPassword())) {
            return user;
        } else {
            return null;
        }
    }
}
