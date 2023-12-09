package kr.co.han.api.domain.repository;

import kr.co.han.api.domain.entity.SampleMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleMemberRepository extends JpaRepository<SampleMember, Long>{

    public void aa();
}
