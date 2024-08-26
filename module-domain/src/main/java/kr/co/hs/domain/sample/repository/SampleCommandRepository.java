package kr.co.hs.domain.sample.repository;

import kr.co.hs.domain.sample.entity.Sample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleCommandRepository extends JpaRepository<Sample, Long>{

}
