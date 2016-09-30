package site.lovecode.boot.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

/**
 * Created by ZN_mager on 16/8/1.
 */
public class DesUtil {

    private static Log log = LogFactory.getLog(DesUtil.class);

    public static final String PASS = "rc2016!@";

    /**
     * 加密
     *
     * @param datasource byte[]
     * @param password   String
     * @return byte[]
     */
    public static byte[] encrypt(byte[] datasource, String password) {
        try {
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(password.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            return cipher.doFinal(datasource);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     *
     * @param src      byte[]
     * @param password String
     * @return byte[]
     * @throws Exception
     */
    public static byte[] decrypt(byte[] src, String password) throws Exception {
        SecureRandom random = new SecureRandom();
        DESKeySpec desKey = new DESKeySpec(password.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(desKey);
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, securekey, random);
        return cipher.doFinal(src);
    }


    /**
     *
     * <p>
     * Des加密str，然后base64转换
     * @param str
     * @return
     * @return String
     */
    public static String encrypt(String str) {
        byte[] byteMi = null;
        byte[] byteMing = null;
        String strMi = "";
        try {
            byteMing = str.getBytes("utf-8");
            byteMi = encrypt(byteMing, PASS);
            BASE64Encoder base64Encoder = new BASE64Encoder();
            strMi = base64Encoder.encode(byteMi);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return strMi;
    }

    /**
     *
     * <p>
     * Base64转换str,然后进行des解密
     * @return
     * @return String
     */
    public static String decrypt(String str) {
        byte[] byteMing = null;
        String strMing = "";
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            byteMing = decoder.decodeBuffer(str);
            byteMing = decrypt(byteMing,PASS);
            strMing = new String(byteMing);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return strMing;
    }


    public static void main(String[] args) {
        String data = "{\n" +
                "    \"appId\":0,\n" +
                "    \"userId\":1,\n" +
                "    \"loginToken\":\"\"\n" +
                "}";
        String s1 = decrypt(data);
        log.info(s1);
    }


}
