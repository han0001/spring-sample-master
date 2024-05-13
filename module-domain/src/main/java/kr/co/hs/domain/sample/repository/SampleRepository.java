package kr.co.hs.domain.sample.repository;

import kr.co.hs.domain.sample.entity.Sample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepository extends JpaRepository<Sample, Long>{

}
