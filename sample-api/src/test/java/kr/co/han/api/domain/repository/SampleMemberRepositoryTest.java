package kr.co.han.api.domain.repository;

import kr.co.han.api.domain.entity.SampleMember;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class SampleMemberRepositoryTest {

    @Autowired
    private SampleMemberRepository sampleMemberRepository;

    @Test
    void aa(){
        SampleMember sampleMember = new SampleMember("홍길동");
        sampleMemberRepository.save(sampleMember);
        System.out.println("123");
    }

}