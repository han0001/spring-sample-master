package kr.co.han.domain.sample.repository;

import kr.co.han.domain.sample.entity.Sample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepository extends JpaRepository<Sample, Long>{

}
