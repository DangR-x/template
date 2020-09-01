package highnes.top.template.controller;

import highnes.top.template.VO.entity.Admin;
import highnes.top.template.VO.requestDTO.LoginAdminParam;
import highnes.top.template.security.util.CommonResult;
import highnes.top.template.util.RSAUtil;
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


    @RequestMapping(value = "/test1",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult test(@RequestBody String str){
        System.out.println(str);
        String message = "{\"username\":\"这是测试\",\"password\":\"123456789\",\"merchantNo\":\"shang001\"}";


        String publicKeyStr = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCWY1VKIXGStXOMtSkb2nqV9A4V6MqlTPv8Dg9Sdxm8TZgOYJJxFAjpUOwt0au6q5JDTrslZngg9um1IhNJlRLEySbTvN7Bzeq6XOpZx5w6XRZ+7/o0Ui4YvcYwIHB5DgS5XJnLa3vLqWOk4NAtY0lqC20170mHi5Fmjdak63OTzwIDAQAB";
        String privateKeyStr = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJZjVUohcZK1c4y1KRvaepX0DhXoyqVM+/wOD1J3GbxNmA5gknEUCOlQ7C3Rq7qrkkNOuyVmeCD26bUiE0mVEsTJJtO83sHN6rpc6lnHnDpdFn7v+jRSLhi9xjAgcHkOBLlcmctre8upY6Tg0C1jSWoLbTXvSYeLkWaN1qTrc5PPAgMBAAECgYAJuQBRm5npHzwKM8glmdllCnNCrVs0lqaP5CTPcw3B485Z15qAHwh4dRff2ndcySzalyN4RoirsOrpH/vZPP8KinIhOT9zcHInWMKEPqGH+twB+c0hS6x2YZFuJqW3+zy56jnUMn3MDjNF5A5N9hD6taP1V+UOqgZvYwwMSCFLkQJBANZtQS2AqahHNjPgjkWcuaG8zXzgbu0VeU+wXDjxR81aLLJBOK6AGe7w5yJnip2w/FqGxPfORcn/bLxyDHOhpQcCQQCzi5zeeiXt1cxeGGqVxNvC51PuSna9YnPs+phiwwGVdAqVdMOJzsThs5EDVhX4eQYIeA4B6PItiPLHsw+6AXD5AkAp/ac/4+xVeeyRaC40T6bCl5ieFc1jPEtPYbgNpqJrAneySLdy5L8vXZnF0QUCMICasb2s0YY1MoH2vVbW5hbNAkEAsCxD5oFQikiI2aN3ojGhuWMnFeB3Fmlueo+ByxaxjSZp5DDIVYZP5W8+0Vk9Aawu4Ux74h/i0g9Yud7XhZo4cQJARyq8WJGDawo65CVcQQ2opbL8LqApr7Co4CAKmV4YFDraY00q9h1Dbj7WO+urJz7XUqbEYG0Yga+37jQAnQHUUQ==";
        String byte2Base64 = RSAUtil.privateDecrypt(str, privateKeyStr);
        System.out.println(byte2Base64);
        return CommonResult.success(RSAUtil.publicEncrypt(message,publicKeyStr));
    }


}
