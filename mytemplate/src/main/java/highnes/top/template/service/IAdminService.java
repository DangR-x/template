package highnes.top.template.service;



import highnes.top.template.VO.entity.Admin;
import highnes.top.template.VO.entity.AdminDetails;
import highnes.top.template.VO.entity.Menu;
import highnes.top.template.VO.requestDTO.AdminParam;
import highnes.top.template.VO.requestDTO.UpdateAdminPasswordParam;
import highnes.top.template.security.util.CommonResult;

import java.io.Serializable;
import java.util.List;


/**
 * @author DangR-X
 * @date 2020/8/25
 * @description
 */
public interface IAdminService {

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username,String password);

    void insert(Admin admin);

    //Serializable是Long，string等等的顶级接口
    void deleteById(Serializable id);

    void updateById(Admin t);

    Admin selectById(Serializable id);

    List<Admin> selectAll();

    Admin selectByUserName(String name);

    AdminDetails loadUserByUsername(String name);

    CommonResult register(AdminParam admin);

    String refreshToken(String oldtoken);

    int updatePassword(UpdateAdminPasswordParam updateAdminPasswordParam);

    int updatePermission(Long adminId,List<Long> permissionIds);

    List<Menu> selectMenuByAdminId(Long id);

}
