package com.tiankong44.tool.util;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.asymmetric.Sign;
import cn.hutool.crypto.asymmetric.SignAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

/**
 * @Description :
 * @Author zhanghao_SMEICS
 * @Date 2022/11/1  16:22
 **/
public class RsaUtil {


    @Value("privateKey")
    private static String privateKey;

    @Value("publicKey")
    public static String publicKey;


    public static String encrypt(String text) {
        RSA rsa = new RSA(privateKey, publicKey);
        //公钥加密，私钥解密
        byte[] encrypt = rsa.encrypt(StrUtil.bytes(text, CharsetUtil.CHARSET_UTF_8), KeyType.PublicKey);
        System.out.println("公钥加密：" + bytesToBase64(encrypt));

        return bytesToBase64(encrypt);
    }




    public static void main(String[] args) {
        String text = "人最宝贵的是生命.生命对每个人只有一次.人的一生应当这样度过：当他回首往事的时候,不会因为虚度年华而悔恨,也不会因为碌碌无为而羞耻.这样,在临死的时候,他能够说：“我已把自己的整个的生命和全部的精力献给了世界上最壮丽的事业---------为人类的解放而斗争.”";
        System.out.println("原文：" + text);



//        //私钥加密，公钥解密
//        byte[] encrypt2 = rsa.encrypt(StrUtil.bytes(text, CharsetUtil.CHARSET_UTF_8), KeyType.PrivateKey);
//        System.out.println("私钥加密：" + bytesToBase64(encrypt2));
//        byte[] decrypt2 = rsa.decrypt(encrypt2, KeyType.PublicKey);
//        System.out.println("公钥解密：" + bytesToBase64(decrypt2));
//
//         Sign sign = SecureUtil.sign(SignAlgorithm.SHA256withRSA, privateKeyStr, publicKeyStr);
//         //签名
//         byte[] data = text.getBytes(StandardCharsets.UTF_8);
//         byte[] signed = sign.sign(data);
//         String signedStr = bytesToBase64(signed);
//         System.out.println("签名：" + signedStr);
//
//         //验证签名
//         boolean verify = sign.verify(data, base64ToBytes(signedStr));
//         System.out.println("验签：" + verify);

        String encrypt1 = encrypt(text);
        System.out.println(encrypt1);


    }


    /**
     * 字节数组转Base64编码
     *
     * @param bytes 字节数组
     * @return Base64编码
     */
    private static String bytesToBase64(byte[] bytes) {
        byte[] encodedBytes = Base64.getEncoder().encode(bytes);
        return new String(encodedBytes, StandardCharsets.UTF_8);
    }

    /**
     * Base64编码转字节数组
     *
     * @param base64Str Base64编码
     * @return 字节数组
     */
    private static byte[] base64ToBytes(String base64Str) {
        byte[] bytes = base64Str.getBytes(StandardCharsets.UTF_8);
        return Base64.getDecoder().decode(bytes);
    }
}
