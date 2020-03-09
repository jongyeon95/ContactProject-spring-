package kr.co.contactproject.contact.api.controller;


import kr.co.contactproject.contact.model.entity.Group;
import kr.co.contactproject.contact.model.network.request.GroupApiRequest;
import kr.co.contactproject.contact.model.network.response.GroupApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/group")
public class GroupApiController
        extends CrudApiController<GroupApiRequest, GroupApiResponse, Group> {

}
