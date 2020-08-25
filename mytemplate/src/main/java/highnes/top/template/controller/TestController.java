package highnes.top.template.controller;

import highnes.top.template.VO.requestDTO.LoginAdminParam;
import highnes.top.template.security.util.CommonResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author DangR-X
 * @date 2020/8/25
 * @description
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult test(String str){
        System.out.println(str);
       return CommonResult.failed("成功！");
    }


}
