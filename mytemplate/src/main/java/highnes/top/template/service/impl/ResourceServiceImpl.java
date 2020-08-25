package highnes.top.template.service.impl;

import highnes.top.template.mapper.ResourceMapper;
import highnes.top.template.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import highnes.top.template.VO.entity.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @author DangR-X
 * @date 2020/8/25
 * @description
 */
@Service
public class ResourceServiceImpl implements IResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public void insert(Resource resource) {
        resourceMapper.insert(resource);
    }

    @Override
    public void deleteById(Serializable id) {
        resourceMapper.deleteById(id);
    }

    @Override
    public void updateById(Resource resource) {
        resourceMapper.updateById(resource);
    }

    @Override
    public Resource selectById(Serializable id) {
        return resourceMapper.selectById(id);
    }

    @Override
    public List<Resource> selectAll() {
        return resourceMapper.selectAll();
    }

    @Override
    public List<Resource> getResourceByAminId(Long adminid) {
        return resourceMapper.getResourceByAminId(adminid);
    }


}
