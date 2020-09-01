package highnes.top.template.util;

import highnes.top.template.VO.entity.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.io.IOException;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author DangR-X
 * @date 2020/8/31
 * @description
 */

public class RSAUtil {

    private static Logger logger = LoggerFactory.getLogger(RSAUtil.class);

    //生成秘钥对
    public static KeyPair getKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        return keyPair;
    }

    //获取公钥(Base64编码)
    public static String getPublicKey(KeyPair keyPair) {
        PublicKey publicKey = keyPair.getPublic();
        byte[] bytes = publicKey.getEncoded();
        return byte2Base64(bytes);
    }

    //获取私钥(Base64编码)
    public static String getPrivateKey(KeyPair keyPair) {
        PrivateKey privateKey = keyPair.getPrivate();
        byte[] bytes = privateKey.getEncoded();
        return byte2Base64(bytes);
    }

    //将Base64编码后的公钥转换成PublicKey对象
    public static PublicKey string2PublicKey(String pubStr) throws Exception {
        byte[] keyBytes = base642Byte(pubStr);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }

    //将Base64编码后的私钥转换成PrivateKey对象
    public static PrivateKey string2PrivateKey(String priStr) throws Exception {
        byte[] keyBytes = base642Byte(priStr);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }

    //公钥加密
    public static String publicEncrypt(String content, String publicKey) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, string2PublicKey(publicKey));
            byte[] bytes = cipher.doFinal(content.getBytes());
            return byte2Base64(bytes);
        } catch (Exception e) {
            logger.error("公钥加密失败{}", e);
        }
        return null;
    }

    //私钥解密
    public static String privateDecrypt(String content, String privateKey) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, string2PrivateKey(privateKey));
            byte[] bytes = cipher.doFinal(base642Byte(content));
            return new String(bytes);
        } catch (Exception e) {
            logger.error("私钥解密失败{}", e);
        }
        return null;
    }

    //字节数组转Base64编码
    public static String byte2Base64(byte[] bytes) {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(bytes);
    }

    //Base64编码转字节数组
    public static byte[] base642Byte(String base64Key) throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();
        return decoder.decodeBuffer(base64Key);
    }

    public static void main(String[] args) {
        try {

            String publicKeyStr = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCWY1VKIXGStXOMtSkb2nqV9A4V6MqlTPv8Dg9Sdxm8TZgOYJJxFAjpUOwt0au6q5JDTrslZngg9um1IhNJlRLEySbTvN7Bzeq6XOpZx5w6XRZ+7/o0Ui4YvcYwIHB5DgS5XJnLa3vLqWOk4NAtY0lqC20170mHi5Fmjdak63OTzwIDAQAB";
            //=================客户端=================
            String message = "{\"username\":\"请求的\",\"password\":\"123\",\"merchantNo\":\"shang001\"}";

            //用公钥加密
            String byte2Base64 = RSAUtil.publicEncrypt(message.toString(), publicKeyStr);
            System.out.println(byte2Base64);
//            System.out.println("公钥加密并Base64编码的结果：" + byte2Base64);
//            //===================服务端================
//            String privateKeyStr = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJZjVUohcZK1c4y1KRvaepX0DhXoyqVM+/wOD1J3GbxNmA5gknEUCOlQ7C3Rq7qrkkNOuyVmeCD26bUiE0mVEsTJJtO83sHN6rpc6lnHnDpdFn7v+jRSLhi9xjAgcHkOBLlcmctre8upY6Tg0C1jSWoLbTXvSYeLkWaN1qTrc5PPAgMBAAECgYAJuQBRm5npHzwKM8glmdllCnNCrVs0lqaP5CTPcw3B485Z15qAHwh4dRff2ndcySzalyN4RoirsOrpH/vZPP8KinIhOT9zcHInWMKEPqGH+twB+c0hS6x2YZFuJqW3+zy56jnUMn3MDjNF5A5N9hD6taP1V+UOqgZvYwwMSCFLkQJBANZtQS2AqahHNjPgjkWcuaG8zXzgbu0VeU+wXDjxR81aLLJBOK6AGe7w5yJnip2w/FqGxPfORcn/bLxyDHOhpQcCQQCzi5zeeiXt1cxeGGqVxNvC51PuSna9YnPs+phiwwGVdAqVdMOJzsThs5EDVhX4eQYIeA4B6PItiPLHsw+6AXD5AkAp/ac/4+xVeeyRaC40T6bCl5ieFc1jPEtPYbgNpqJrAneySLdy5L8vXZnF0QUCMICasb2s0YY1MoH2vVbW5hbNAkEAsCxD5oFQikiI2aN3ojGhuWMnFeB3Fmlueo+ByxaxjSZp5DDIVYZP5W8+0Vk9Aawu4Ux74h/i0g9Yud7XhZo4cQJARyq8WJGDawo65CVcQQ2opbL8LqApr7Co4CAKmV4YFDraY00q9h1Dbj7WO+urJz7XUqbEYG0Yga+37jQAnQHUUQ==";
//            //解密后的明文
//            System.out.println("解密后的明文: " + RSAUtil.privateDecrypt(byte2Base64, privateKeyStr));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
