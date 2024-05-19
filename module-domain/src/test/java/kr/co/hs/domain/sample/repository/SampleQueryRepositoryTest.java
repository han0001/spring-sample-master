package kr.co.hs.domain.sample.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kr.co.hs.domain.sample.record.SampleRecord;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static kr.co.hs.domain.sample.entity.QSample.sample;

@Slf4j
//@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SampleQueryRepositoryTest {

    @PersistenceContext
    EntityManager em;

    @Test
    public void 샘플_조회하기(){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<SampleRecord> sampleList  = queryFactory
                .select(Projections.constructor(SampleRecord.class,
                                sample.id,
                                sample.name,
                                sample.legacyPayType))
                .from(sample)
                .where(sample.id.eq(20L))
                .fetch();

        log.info("itemList: {}", sampleList);
    }


}