package kr.co.hs.domain.modules.sample.infrastructure;

import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.hs.domain.modules.sample.domain.model.Sample;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static kr.co.hs.domain.modules.sample.domain.model.QSample.sample;


@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SampleQueryRepository {

    private final JPAQueryFactory queryFactory;

    public Optional<Sample> findById(Long id){
        return Optional.ofNullable(queryFactory
                .selectFrom(sample)
                .where(sample.id.eq(id))
                .fetchOne());
    }

//    public SampleRecord findById(Long id){
//        return queryFactory
//                .select(Projections.constructor(SampleRecord.class,
//                        sample.id,
//                        sample.name,
//                        sample.legacyPayType))
//                .from(sample)
//                .where(sample.id.eq(id))
//                .fetchOne();
//    }
}
