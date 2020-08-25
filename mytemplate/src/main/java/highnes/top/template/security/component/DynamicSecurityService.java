package highnes.top.template.security.component;

import org.springframework.security.access.ConfigAttribute;

import java.util.Map;

/**
 * @author DangR-X
 * @date 2020/8/25
 * @description 动态权限相关业务类,将所有需要权限访问额路径注入进scurity
 */
public interface DynamicSecurityService {
    /**
     * 加载资源ANT通配符和资源对应MAP
     */
    Map<String, ConfigAttribute> loadDataSource();
}
