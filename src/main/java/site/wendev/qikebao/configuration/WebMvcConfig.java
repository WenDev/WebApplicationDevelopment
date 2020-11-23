package site.wendev.qikebao.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import site.wendev.qikebao.interceptor.LoginInterceptor;

/**
 * 拦截器、静态资源等配置
 *
 * @author 江文
 * @since 2020/11/18 7:41 下午
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Value("${file.location}")
    private String fileLocation;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns(
                "/css/**",
                "/images/**",
                "/picture/**",
                "/script/**",
                "/login"
        );
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 添加上传文件的静态资源处理器
        registry.addResourceHandler("/file/**").addResourceLocations("file:" + fileLocation);
    }
}
