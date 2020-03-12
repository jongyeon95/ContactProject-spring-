package kr.co.contactproject.contact.model.network.response;

import kr.co.contactproject.contact.model.entity.Group;
import kr.co.contactproject.contact.model.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupDetailApiResponse {
    private Long id;

    private String groupName;

    private String personName;

}
