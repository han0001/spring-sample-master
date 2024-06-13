package kr.co.hs.domain.modules.sample.infrastructure;

import kr.co.hs.domain.modules.sample.domain.model.Sample;
import kr.co.hs.domain.modules.sample.domain.model.SampleRepository;
import kr.co.hs.domain.modules.sample.infrastructure.platform.SampleJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class SampleRepositoryImpl implements SampleRepository {

    private final SampleJpaRepository sampleJpaRepository;

    @Override
    public Sample findById(Long id) {
        return sampleJpaRepository.findById(id).orElse(null);
    }
}

