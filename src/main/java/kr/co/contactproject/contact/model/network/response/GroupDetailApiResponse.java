package kr.co.contactproject.contact.model.network.response;

import kr.co.contactproject.contact.model.entity.Group;
import kr.co.contactproject.contact.model.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupDetailApiResponse {
    private Long id;

    private Group group;

    private Person person;

}
