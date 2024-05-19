package kr.co.hs.domain.sample.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.hs.domain.sample.record.SampleRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static kr.co.hs.domain.sample.entity.QSample.sample;

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

    public List<SampleRecord> findAllForBatch(int page, int pageSize){
        return queryFactory
                .select(Projections.constructor(SampleRecord.class,
                        sample.id,
                        sample.name,
                        sample.legacyPayType))
                .from(sample)
                .offset(page * pageSize)
                .limit(pageSize)
                .orderBy(Sort.by(Sort.Direction.ASC, ""))
                .fetch();
    }

}
