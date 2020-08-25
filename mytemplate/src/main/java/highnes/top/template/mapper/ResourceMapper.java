package highnes.top.template.mapper;

import highnes.top.template.VO.entity.Resource;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * @author DangR-X
 * @date 2020/8/25
 * @description
 */
@Component
public interface ResourceMapper {

    void insert(Resource resource);

    //Serializable是Long，string等等的顶级接口
    void deleteById(Serializable id);

    void updateById(Resource resource);

    Resource selectById(Serializable id);

    List<Resource> selectAll();

    List<Resource> getResourceByAminId(Long adminid);


}
