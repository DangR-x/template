package highnes.top.template.service.impl;

import highnes.top.template.VO.entity.AdminRole;
import highnes.top.template.mapper.AdminRoleMapper;
import highnes.top.template.service.IAdminRoleService;
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
public class AdminRoleServiceImpl implements IAdminRoleService {

    @Autowired
    private AdminRoleMapper adminRoleMapper;

    @Override
    public void insert(AdminRole adminRole) {
        adminRoleMapper.insert(adminRole);
    }

    @Override
    public void deleteById(Serializable id) {
        adminRoleMapper.deleteById(id);
    }

    @Override
    public void updateById(AdminRole adminRole) {
        adminRoleMapper.updateById(adminRole);
    }

    @Override
    public AdminRole selectById(Serializable id) {
        return adminRoleMapper.selectById(id);
    }

    @Override
    public List<AdminRole> selectAll() {
        return adminRoleMapper.selectAll();
    }


    @Override
    public void deleteByAdminId(Long adminId) {
        AdminRole adminRole = adminRoleMapper.selectByAdminId(adminId);
        adminRoleMapper.deleteById(adminRole.getId());
    }
}
