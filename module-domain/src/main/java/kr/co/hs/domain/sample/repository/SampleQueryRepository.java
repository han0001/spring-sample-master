package kr.co.hs.domain.sample.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.hs.domain.sample.record.SampleRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static kr.co.hs.domain.sample.entity.QSample.sample;

@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SampleQueryRepository {

    private final JPAQueryFactory queryFactory;

    public List<SampleRecord> findById(Long id){
        return queryFactory
                .select(Projections.fields(SampleRecord.class,
                        sample.id,
                        sample.name))
                .from(sample)
                .where(sample.id.eq(id))
                .fetch();
    }

}
