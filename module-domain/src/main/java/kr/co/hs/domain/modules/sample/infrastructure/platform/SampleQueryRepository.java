package kr.co.hs.domain.modules.sample.infrastructure.platform;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.hs.domain.modules.sample.domain.model.SampleRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static kr.co.hs.domain.modules.sample.domain.model.QSample.sample;


@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SampleQueryRepository {

    private final JPAQueryFactory queryFactory;

    public List<SampleRecord> findById(Long id){
        return queryFactory
                .select(Projections.constructor(SampleRecord.class,
                        sample.id,
                        sample.name,
                        sample.legacyPayType))
                .from(sample)
                .where(sample.id.eq(id))
                .fetch();
    }


}
