package kr.co.han.domain.config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.iv.RandomIvGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JasyptConfigTest {
    @Test
    void getEnc() {
        String url = "jdbc:mysql://sw-dev-mysql.cfai6mmcgbfw.ap-northeast-2.rds.amazonaws.com:3306/mydb?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
        String username = "root";
        String password = "rootrootpw";

        System.out.println(jasyptEncoding(url));
        System.out.println(jasyptEncoding(username));
        System.out.println(jasyptEncoding(password));
    }

    public String jasyptEncoding(String value) {
        String key = "";
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWithMD5AndDES");
        pbeEnc.setPassword(key);
        pbeEnc.setIvGenerator(new RandomIvGenerator());
        return pbeEnc.encrypt(value);
    }

}