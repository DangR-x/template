package highnes.top.template.util;

import org.apache.commons.codec.binary.Base64;
import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;

/**
 * @author DangR-X
 * @date 2020/9/10
 * @description 动态RSA加密解密
 */
public class DynamicRSAUtil {


    /** */
    /**
     * 加密算法RSA
     */
    public static final String KEY_ALGORITHM = "RSA";

    /** */
    /**
     * 签名算法
     */
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    /** */
    /**
     * 获取公钥的key
     */
    private static final String PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAooo/b2JCGJIq2oNTEBNzwbSG5EilW5E8r8dzorAkv07IKex3XHtEQZ3NGN5nNIi0uzscNRNqr7jV/YxcN3qc1yEZ/YiYsbDeEJySE+X01/F+VCPi71OINSNFPyWnDLu1wTVoqLZaJfQqody1zj4t3cE59Eez9s/p10LyhGC8TKDMSpUgtn+6HTcQMku1OKM2dCLStfeBu7Pvm1Yq301Xe1tf7H8ZEnExlBxQ5G83wg2nadZmTSIeI2VAdWaimVIFEEay5xfb6y+45Jg11W/UobaT3kvYZATkzYeIUz7C4QJ+fuf4+3/+qMrtYPWe51Kr3rJn3uOBQS7uGQ9HeBuBQwIDAQAB";

    /** */
    /**
     * 获取私钥的key
     */
    private static final String PRIVATE_KEY = "MIIEwAIBADANBgkqhkiG9w0BAQEFAASCBKowggSmAgEAAoIBAQCiij9vYkIYkirag1MQE3PBtIbkSKVbkTyvx3OisCS/Tsgp7Hdce0RBnc0Y3mc0iLS7Oxw1E2qvuNX9jFw3epzXIRn9iJixsN4QnJIT5fTX8X5UI+LvU4g1I0U/JacMu7XBNWiotlol9Cqh3LXOPi3dwTn0R7P2z+nXQvKEYLxMoMxKlSC2f7odNxAyS7U4ozZ0ItK194G7s++bVirfTVd7W1/sfxkScTGUHFDkbzfCDadp1mZNIh4jZUB1ZqKZUgUQRrLnF9vrL7jkmDXVb9ShtpPeS9hkBOTNh4hTPsLhAn5+5/j7f/6oyu1g9Z7nUqvesmfe44FBLu4ZD0d4G4FDAgMBAAECggEBAITLvpgaBzZb9Xch5DM2MVUJUUwhrjfpqVNT+T3p+5vxmcfm0n5Ul6ekbXTsABYDuuVdneYfPwLiWLMWgiExpAJ/oORrPZWvkz6vLQnkzu2++B92UmqGLLp9Xo4BDUJx+kUohaGRmoV3v30O/drLIl4TCG50RqxXog2lPM662h0fzSJQZWdUIInGwooj5XmHLYKwxKPh3yQ50ORYXejidZRfZoIabW26YJOrsmajShdDzKc0yLSIaIJjzI9wM726yfkt6KcIFypta4KqYWMcH4pmF2BiWCm1C3ughBk7xoWdp4aXJZC9pDcU8z7ltyFJlnx52x5lU8GLfES199OtlIECgYEA/vodoeUYxpgsqc/moQshrrOyPp0P5szV92mlgb9Q803J28F6p/IrpPow6eMxcCh35MlZ4FxQIDwdtre8X5njxgbBUUsLYSAofXAyFUaW+jL5yfJSYPBcuJ0tVVVd18V0rg0DSLq8XeyAK/QxDgsvr5jI4/MAiqC9SCZTNpERb+sCgYEAozEw46S4WHf2fWfpAEz2bG7c8N3ulx4F/d0dnvulzZj8XrcUlc5X6rPyVaq7utnQpRWZBOHvphvZ4igqYWCXBWCJsdUJPLP7AKCf8K6unSBqPTYXuAjq5GR3bDQnhu1UTTFMF/wNxNHlpw2PyrJxIQogoko0zkeOnPVwinzpNgkCgYEAjEJkGJGgzmYZc5Q05vPrpGGfNIhLngeh0Abij3wBeMWau/MzmL1Duu4SCCb9JBhu04DbmurM/N507fUmf2R1ApLmtuRULyp0e4RDWKbLGHkAJVHSdRbjun5j2KQsCizJYZEw9EocooIdg5BBh9spcSvXnmUnMBr55H2ImuS0Nd8CgYEAlbQSfUImOkISRIiGHlh71oz88Zklvks0g+XLvoRrXWfyW5DnuWVJEW1x6VRuUsJtvINLlEcPaPozrlvaROouoCgnKJOdnaodoD25ezlDxbBuxShSKelEUbA4PXK6r/QXWZjXjUkT+HH0koLGXdPEI+L+fOJF/tV15lbhnqln5sECgYEA0HLx4z13O4E51THY+rFnRS8IAm/xok21jFEXiXsk9YF8r7V4JwyKiSwX8ylvivj2jsxVcCoIWNEFC8eFzSedf6b+NXHz1RhU2LKjkLQ4PFx3krKd08z3hV7CsGPYsY7ms92+yfgC8aJfocJRN/o/pKvVvd/qN6/tWSfR/q+LKw0=";

    /** */
    /**
     * RSA最大加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 117;

    /** */
    /**
     * RSA最大解密密文大小 128
     */
    private static final int MAX_DECRYPT_BLOCK = 256;

    /** */
    /**
     * RSA 位数 如果采用2048 上面最大加密和最大解密则须填写:  245 256
     */
    private static final int INITIALIZE_LENGTH = 1024;

    /** */
    /**
     * <p>
     * 生成密钥对(公钥和私钥)
     * </p>
     *
     * @return
     * @throws Exception
     */
    public static Map<String, Object> genKeyPair() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(INITIALIZE_LENGTH);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        Map<String, Object> keyMap = new HashMap<String, Object>(2);
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;
    }

    /** */
    /**
     * <p>
     * 用私钥对信息生成数字签名
     * </p>
     *
     * @param data
     *            已加密数据
     * @param privateKey
     *            私钥(BASE64编码)
     *
     * @return
     * @throws Exception
     */
    public static String sign(byte[] data, String privateKey) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(privateK);
        signature.update(data);
        return Base64.encodeBase64String(signature.sign());
    }

    /** */
    /**
     * <p>
     * 校验数字签名
     * </p>
     *
     * @param data
     *            已加密数据
     * @param publicKey
     *            公钥(BASE64编码)
     * @param sign
     *            数字签名
     *
     * @return
     * @throws Exception
     *
     */
    public static boolean verify(byte[] data, String publicKey, String sign) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(publicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey publicK = keyFactory.generatePublic(keySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(publicK);
        signature.update(data);
        return signature.verify(Base64.decodeBase64(sign));
    }

    /** */
    /**
     * <P>
     * 私钥解密
     * </p>
     *
     * @param encryptedData
     *            已加密数据
     * @param privateKey
     *            私钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] encryptedData, String privateKey) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateK);
        int inputLen = encryptedData.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
//            MAX_DECRYPT_BLOCK
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        return decryptedData;
    }

    /** */
    /**
     * <p>
     * 公钥解密
     * </p>
     *
     * @param encryptedData
     *            已加密数据
     * @param publicKey
     *            公钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPublicKey(byte[] encryptedData, String publicKey) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicK = keyFactory.generatePublic(x509KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicK);
        int inputLen = encryptedData.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        return decryptedData;
    }

    /** */
    /**
     * <p>
     * 公钥加密
     * </p>
     *
     * @param data
     *            源数据
     * @param publicKey
     *            公钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data, String publicKey) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicK = keyFactory.generatePublic(x509KeySpec);
        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicK);
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段加密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        return encryptedData;
    }

    /** */
    /**
     * <p>
     * 私钥加密
     * </p>
     *
     * @param data
     *            源数据
     * @param privateKey
     *            私钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(byte[] data, String privateKey) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateK);
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段加密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        return encryptedData;
    }

    /** */
    /**
     * <p>
     * 获取私钥
     * </p>
     *
     * @param keyMap
     *            密钥对
     * @return
     * @throws Exception
     */
    public static String getPrivateKey(Map<String, Object> keyMap) throws Exception {
        Key key = (Key) keyMap.get(PRIVATE_KEY);
        return Base64.encodeBase64String(key.getEncoded());
    }

    /** */
    /**
     * <p>
     * 获取公钥
     * </p>
     *
     * @param keyMap
     *            密钥对
     * @return
     * @throws Exception
     */
    public static String getPublicKey(Map<String, Object> keyMap) throws Exception {
        Key key = (Key) keyMap.get(PUBLIC_KEY);
        return Base64.encodeBase64String(key.getEncoded());
    }

    /**
     * java端公钥加密
     */
    public static String pulbicencryptedDataOnJava(String data) {
        try {
            data = Base64.encodeBase64String(encryptByPublicKey(data.getBytes(), PUBLIC_KEY));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return data;
    }

    /**
     * java端公钥解密
     */
    public static String pulbicDecryptDataOnJava(String data) {
        String temp = "";
        try {
            byte[] rs = Base64.decodeBase64(data);
            temp = new String(DynamicRSAUtil.decryptByPublicKey(rs, PUBLIC_KEY),"UTF-8");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    /**
     * java端私钥解密
     */
    public static String privateDecryptDataOnJava(String data) {
        String temp = "";
        try {
            byte[] rs = Base64.decodeBase64(data);
            temp = new String(DynamicRSAUtil.decryptByPrivateKey(rs, PRIVATE_KEY),"UTF-8");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }
    /**
     * java端私钥加密
     */
    public static String privateEncryptedDataOnJava(String data) {
        try {
            data = Base64.encodeBase64String(encryptByPrivateKey(data.getBytes(), PRIVATE_KEY));
//            data = Base64.encodeBase64String(encryptByPrivateKey(new String(data.getBytes("UTF-8"),"GBK").getBytes(), PRIVATE_KEY));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return data;
    }
    /**
     * java端私钥加密
     */
    public static String privateEncryptedDataOnGson(Object data) {

        String str = privateEncryptedDataOnJava(GsonUtil.toJson(data));
        return str;
    }

    /**
     * java端公钥加密
     */
    public static String encryptedDataOnJava(String data, String PUBLICKEY) {
        try {
            data = Base64.encodeBase64String(encryptByPublicKey(data.getBytes(), PUBLICKEY));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return data;
    }

    /**
     * java端私钥解密
     */
    public static String decryptDataOnJava(String data, String PRIVATEKEY) {
        String temp = "";
        try {
            byte[] rs = Base64.decodeBase64(data);
            temp = new String(DynamicRSAUtil.decryptByPrivateKey(rs, PRIVATEKEY),"UTF-8");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }


    public static void main(String[] args) throws  Exception{

        String message = "{\"id\":1,\"username\":\"jklnadkfn-X\",\"password\":\"$2a$10$Sy.Am0hwVekKmFkShn4fEuE5yH0Qr6T061HF8TIpagJXoDEMtVpnW\",\"code\":\"/\",\"icon\":null,\"email\":\"1023056792@qq.com\",\"nickName\":\"牛逼\",\"note\":null,\"createTime\":\"Aug 25, 2020 5:02:36 PM\",\"loginTime\":null,\"status\":1,\"phone\":\"无\"}";

        String encryBase = "kWizaejInwb24mRzDHE/76sBk+CoxPiMejBbubP0en1hNGzD/W82dUOCwsdv0Kmj+4Ck0mZXAkL4hS6J7Ehehq91XQJ77DS4P09fgOHXqagSfKrw0BadGS1ckC/oxqA8hGHxOAgPFiKPNa5zaQVAdwnt704s5tKUbpKGUElGPF+eZU7AVXc9iLxM+NpN32ryU4soUi0WfSn2h9vLEQPegJq6zV0mho6U8gNxZFLDQOzkFzU1uP7o656QiOenWSTaBgyMjs96inDdh5WgqGRx+ckPzwUAnfmvcL4TO6jfK4xHRSAD4XS7b3zKv0BwthyIMIk4NF3rxYV1to0WSRXIqQ==";

        // 私钥加密
//        String s = privateEncryptedDataOnJava("c5ab4bca4767406881f0c798a44a1c95");
//        System.out.println(s);

        //公钥解密
        String s1 = pulbicDecryptDataOnJava("fErNc2Ej0ZaiarxGecgqQnxYWSmQM8FhrpwwwRxsj1zj6m57F8nngengQVPbYcT6iZA7HSSlFPy5qM40sADPQArIJ3JJ1x2XvFlE/USgahfGPMRXt8sD3xYp70YJYcG3/sx5nZj/CIbhQNNs9r4c15densFy5nPZzoZLLXwFhQULX/1x6IhuOss5Q2uMK5xCk9YKUpqgiA3IDASl6zlZT7zisJUJKOJcpvI/RjuZC5x8H6lHlJnmUpN/ZnTwL60XCFgQWk1xclrA7WE3y95/VrphuC71t0bkqPQAgnO4rpJ0/9wKmiRXx9bKxzjiVvpJOer3VLZvYwB8VQ+HuDzoFA==");
        System.out.println(s1);

        //公钥加密
//        String s = pulbicencryptedDataOnJava("渝AH508F");
//        System.out.println(s);

        //私钥解密
//        String s1 = privateDecryptDataOnJava(encryBase);
//        System.out.println(s1);


    }

}
