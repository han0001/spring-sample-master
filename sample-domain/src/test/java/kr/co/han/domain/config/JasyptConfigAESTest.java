package kr.co.han.domain.config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.iv.RandomIvGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JasyptConfigAESTest {
    @Test
    void getEnc() {
        String url = "";
        String username = "";
        String password = "";

        System.out.println(String.format("url : %s", jasyptEncoding(url)));
        System.out.println(String.format("username : %s", jasyptEncoding(username)));
        System.out.println(String.format("password : %s", jasyptEncoding(password)));
    }

    public String jasyptEncoding(String value) {
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
        pbeEnc.setPassword("1Q2w3e4r");
        pbeEnc.setIvGenerator(new RandomIvGenerator());
        return pbeEnc.encrypt(value);
    }

}