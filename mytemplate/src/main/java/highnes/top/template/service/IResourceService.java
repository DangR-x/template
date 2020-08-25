package highnes.top.template.service;



import highnes.top.template.VO.entity.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @author DangR-X
 * @date 2020/8/25
 * @description
 */
public interface IResourceService {

    void insert(Resource resource);

    //Serializable是Long，string等等的顶级接口
    void deleteById(Serializable id);

    void updateById(Resource resource);

    Resource selectById(Serializable id);

    List<Resource> selectAll();

    List<Resource> getResourceByAminId(Long adminid);
}
