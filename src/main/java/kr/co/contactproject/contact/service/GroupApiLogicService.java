package kr.co.contactproject.contact.service;

import kr.co.contactproject.contact.model.entity.Group;
import kr.co.contactproject.contact.model.network.Header;
import kr.co.contactproject.contact.model.network.request.GroupApiRequest;
import kr.co.contactproject.contact.model.network.response.GroupApiResponse;

import org.springframework.stereotype.Service;

@Service
public class GroupApiLogicService extends BaseService<GroupApiRequest, GroupApiResponse, Group> {

    @Override
    public Header<GroupApiResponse> create(Header<GroupApiRequest> request) {

        GroupApiRequest body=request.getData();
        Group group=Group.builder()
                .name(body.getName())
                .description(body.getDescription())
                .build();
        Group newGroup=baseRepository.save(group);
        return response(newGroup);
    }

    @Override
    public Header<GroupApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<GroupApiResponse> update(Header<GroupApiRequest> request) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        return null;
    }

    public Header<GroupApiResponse> response(Group group){

        GroupApiResponse groupApiResponse=GroupApiResponse.builder()
                .id(group.getId())
                .name(group.getName())
                .description(group.getName())
                .build();

        return Header.OK(groupApiResponse);
    }
}
