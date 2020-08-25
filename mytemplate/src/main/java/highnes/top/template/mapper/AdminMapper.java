package highnes.top.template.mapper;


import highnes.top.template.VO.entity.Admin;
import highnes.top.template.VO.entity.Menu;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;


/**
 * @author DangR-X
 * @date 2020/8/25
 * @description
 */
@Component
public interface AdminMapper {

    void insert(Admin t);

    //Serializable是Long，string等等的顶级接口
    void deleteById(Serializable id);

    void updateById(Admin t);

    Admin selectById(Serializable id);

    List<Admin> selectAll();

    Admin selectByName(String username);

    void updateByName(Admin admin);

    List<Menu> selectMenuByAdminId(Long id);



}
