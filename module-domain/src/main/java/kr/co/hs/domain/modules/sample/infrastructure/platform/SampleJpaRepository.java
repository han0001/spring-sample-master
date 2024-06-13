package kr.co.hs.domain.modules.sample.infrastructure.platform;

import kr.co.hs.domain.modules.sample.domain.model.Sample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleJpaRepository extends JpaRepository<Sample, Long>{

}
