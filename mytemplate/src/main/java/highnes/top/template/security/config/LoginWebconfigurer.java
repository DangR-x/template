package highnes.top.template.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author DangR-X
 * @date 2020/8/31
 * @description
 */
@Configuration
public class LoginWebconfigurer implements WebMvcConfigurer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //将动态页面employee映射到/employee的url下
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/index").setViewName("index");

    }

    /**
     * 注册静态文件的自定义映射路径
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 定义到新文件夹
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
//        // 定义到指定目录
//        registry.addResourceHandler(staticAccessPath)
//                .addResourceLocations("file:" + uploadFolder);
    }


}
