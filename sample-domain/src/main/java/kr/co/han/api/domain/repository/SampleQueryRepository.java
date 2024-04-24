package kr.co.han.api.domain.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SampleQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

//    public List<SampleRecord> findById(Long id){
//        return jpaQueryFactory
//                .select(Projections.fields(SampleRecord.class,
//                        sample.id,
//                        sample.name))
//                .from(sample)
//                .where(sample.id.eq(id))
//                .fetch();
//    }

}
