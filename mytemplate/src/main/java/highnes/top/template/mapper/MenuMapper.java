package highnes.top.template.mapper;


import highnes.top.template.VO.entity.Menu;

import java.io.Serializable;
import java.util.List;

/**
 * @author DangR-X
 * @date 2020/8/25
 * @description
 */
public interface MenuMapper  {

    void insert(Menu menu);

    //Serializable是Long，string等等的顶级接口
    void deleteById(Serializable id);

    void updateById(Menu menu);

    Menu selectById(Serializable id);

    List<Menu> selectAll();
}
