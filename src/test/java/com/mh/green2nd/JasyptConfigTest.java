package com.mh.green2nd;

//public class JasyptConfigTest {
//    @Test
//    @DisplayName("패스워드를 jasypt로 암호화")
//    public void jasyptEncryptorPassword() {
//        String key = "sumin";   // 키를 이용하여 암호화 예정
//
//        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
//        encryptor.setPoolSize(8);   // 코어 수
//        encryptor.setPassword(key);
//        encryptor.setAlgorithm("PBEWithMD5AndTripleDES");  // 암호화 알고리즘
//
//        String str = "1234";
//        String encryptStr = encryptor.encrypt(str);
//        String decryptStr = encryptor.decrypt(encryptStr);
//
//        System.out.println("암호화 된 문자열 : " + encryptStr);
//        System.out.println("복호화 된 문자열 : " + decryptStr);
//    }
//}

import com.mh.green2nd.config.JasyptConfig;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import static org.assertj.core.api.Assertions.assertThat;

public class JasyptConfigTest extends JasyptConfig {

    @Test
    public void jasypt_encrypt_decrypt_test() {
        // 암호할 비밀번호 applcation.yml 에서 가져오기
        String encryptKey = System.getProperty("jasypt.encryptor.password");

        String plainText = "plainText";

        StandardPBEStringEncryptor jasypt = new StandardPBEStringEncryptor();
        jasypt.setPassword(encryptKey);

        String encryptedText = jasypt.encrypt(plainText);
        String decryptedText = jasypt.decrypt(encryptedText);

        System.out.println("암호화 된 문자열 : " + encryptedText);
        System.out.println("복호화 된 문자열 : " + decryptedText);

        assertThat(plainText).isEqualTo(decryptedText);
    }
}
