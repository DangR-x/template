package highnes.top.template.service;


import highnes.top.template.VO.entity.AdminRole;

import java.io.Serializable;
import java.util.List;

/**
 * @author DangR-X
 * @date 2020/8/25
 * @description
 */
public interface IAdminRoleService {

    void insert(AdminRole adminRole);

    //Serializable是Long，string等等的顶级接口
    void deleteById(Serializable id);

    void updateById(AdminRole adminRole);

    AdminRole selectById(Serializable id);

    List<AdminRole> selectAll();

    void deleteByAdminId(Long adminId);
}
