package highnes.top.template.service;

import highnes.top.template.VO.entity.Menu;
import highnes.top.template.VO.entity.Role;

import java.io.Serializable;
import java.util.List;

/**
 * @author DangR-X
 * @date 2020/8/25
 * @description
 */
public interface IRoleService {

    List<Menu> getMenuByAdminId(Long id);

    void insert(Role role);

    //Serializable是Long，string等等的顶级接口
    void deleteById(Serializable id);

    void updateById(Role role);

    Role selectById(Serializable id);

    List<Role> selectAll();
}
