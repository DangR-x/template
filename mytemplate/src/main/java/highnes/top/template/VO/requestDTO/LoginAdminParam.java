package highnes.top.template.VO.requestDTO;

import javax.validation.constraints.NotEmpty;

/**
 * @author DangR-X
 * @date 2020/8/25
 * @description  登录参数
 */
public class LoginAdminParam {
    @NotEmpty(message = "用户名不能为空")
    private String username;
    @NotEmpty(message = "用户名不能为空")
    private String password;

    public LoginAdminParam(@NotEmpty(message = "用户名不能为空") String username, @NotEmpty(message = "用户名不能为空") String password) {
        this.username = username;
        this.password = password;
    }

    public LoginAdminParam() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginAdminParam{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
