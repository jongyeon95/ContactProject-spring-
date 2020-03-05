package kr.co.contactproject.contact.model.network.response;

import kr.co.contactproject.contact.model.entity.GroupDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonApiResponse {
    private Long id;

    private LocalDate birthday;

    private String bloodType;

    private String description;

    private String name;

    private String phoneNumber;

    private List<GroupDetail> groupDetailList;

}
