package highnes.top.template.service.impl;

import highnes.top.template.VO.entity.Menu;
import highnes.top.template.VO.entity.Role;
import highnes.top.template.mapper.RoleMapper;
import highnes.top.template.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @author DangR-X
 * @date 2020/8/25
 * @description
 */
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Menu> getMenuByAdminId(Long id) {
        return roleMapper.getMenuByAdminId(id);
    }

    @Override
    public void insert(Role role) {
        roleMapper.insert(role);
    }

    @Override
    public void deleteById(Serializable id) {
        roleMapper.deleteById(id);
    }

    @Override
    public void updateById(Role role) {
        roleMapper.updateById(role);
    }

    @Override
    public Role selectById(Serializable id) {
        return roleMapper.selectById(id);
    }

    @Override
    public List<Role> selectAll() {
        return roleMapper.selectAll();
    }
}
