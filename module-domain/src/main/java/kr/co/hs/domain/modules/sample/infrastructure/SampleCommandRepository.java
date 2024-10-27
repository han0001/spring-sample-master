package kr.co.hs.domain.modules.sample.infrastructure;

import kr.co.hs.domain.modules.sample.domain.model.Sample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleCommandRepository extends JpaRepository<Sample, Long>{

}
