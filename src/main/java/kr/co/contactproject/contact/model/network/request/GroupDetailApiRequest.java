package kr.co.contactproject.contact.model.network.request;

import kr.co.contactproject.contact.model.entity.Group;
import kr.co.contactproject.contact.model.entity.GroupDetail;
import kr.co.contactproject.contact.model.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupDetailApiRequest {
    private Long id;

    private Long groupId;

    private Long personId;

}
