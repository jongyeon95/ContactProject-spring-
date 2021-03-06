package kr.co.contactproject.contact.model.network.request;

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
public class PersonApiRequest {
    private Long id;

    private Integer age;

    private LocalDate birthday;

    private String bloodType;

    private String description;

    private String name;

    private String phoneNumber;

    private List<Long> groupDetailListId;

}
