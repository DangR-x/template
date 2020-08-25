package highnes.top.template.mapper;


import highnes.top.template.VO.entity.AdminRole;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * @author DangR-X
 * @date 2020/8/25
 * @description
 */
@Component
public interface AdminRoleMapper {

    void insert(AdminRole adminRole);

    //Serializable是Long，string等等的顶级接口
    void deleteById(Serializable id);

    void updateById(AdminRole adminRole);

    AdminRole selectById(Serializable id);

    List<AdminRole> selectAll();

    AdminRole selectByAdminId(Long id);
}
