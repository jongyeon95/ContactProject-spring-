package kr.co.contactproject.contact.model.network.request;

import kr.co.contactproject.contact.model.entity.GroupDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupApiRequest {
    private Long id;

    private String name;

    private String description;


}
