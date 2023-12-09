package kr.co.han.api.domain.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.OpenJPATemplates;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.han.api.domain.entity.Sample;
import kr.co.han.api.domain.record.SampleRecord;
import lombok.RequiredArgsConstructor;
import org.hibernate.criterion.Projection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


import static kr.co.han.api.domain.entity.QSample.sample;
@RequiredArgsConstructor
public class SampleQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<SampleRecord> findById(Long id){
        return jpaQueryFactory
                .select(Projections.fields(SampleRecord.class,
                        sample.id,
                        sample.name))
                .from(sample)
                .where(sample.id.eq(id))
                .fetch();
    }

}
