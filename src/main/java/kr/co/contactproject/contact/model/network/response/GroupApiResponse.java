package kr.co.contactproject.contact.model.network.response;

import kr.co.contactproject.contact.model.entity.GroupDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupApiResponse {
    private Long id;

    private String name;

    private String description;

    private List<GroupDetail> groupDetail;

}
