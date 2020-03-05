package kr.co.contactproject.contact.respository;

import kr.co.contactproject.contact.model.entity.GroupDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupDetailRepository extends JpaRepository<GroupDetail, Long> {

}
