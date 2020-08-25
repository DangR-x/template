package highnes.top.template.security.config;


import highnes.top.template.VO.entity.Resource;
import highnes.top.template.security.component.DynamicSecurityService;
import highnes.top.template.service.IAdminService;
import highnes.top.template.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author DangR-X
 * @date 2020/8/25
 * @description tik-security模块相关配置
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class TikSecurityConfig extends SecurityConfig {

    @Autowired
    private IAdminService adminService;
    @Autowired
    private IResourceService resourceService;

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        return username -> adminService.loadUserByUsername(username);

    }

    @Bean
    public DynamicSecurityService dynamicSecurityService() {
        return new DynamicSecurityService() {
            @Override
            public Map<String, ConfigAttribute> loadDataSource() {
                //将所有需要验证的路径注入进容器内
                Map<String, ConfigAttribute> map = new ConcurrentHashMap<>();
                List<Resource> resources = resourceService.selectAll();
                for (Resource resource : resources) {
                    //将需要验证的所有资源,以路径为键,id和名称为值存入map中在注入进security容器中
                    map.put(resource.getUrl(), new org.springframework.security.access.SecurityConfig(resource.getId() + ":" + resource.getName()));
                }
                return map;
            }
        };
    }
}
