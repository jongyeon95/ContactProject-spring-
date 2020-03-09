package kr.co.contactproject.contact.api.controller;


import kr.co.contactproject.contact.model.entity.GroupDetail;
import kr.co.contactproject.contact.model.network.request.GroupDetailApiRequest;
import kr.co.contactproject.contact.model.network.response.GroupDetailApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/groupDetail")
public class GroupDetailApiController
        extends CrudApiController<GroupDetailApiRequest, GroupDetailApiResponse,GroupDetail> {

}
