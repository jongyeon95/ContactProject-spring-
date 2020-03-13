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
        return baseRepository.findById(id).map(group -> response(group)).orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<GroupApiResponse> update(Header<GroupApiRequest> request) {
        return baseRepository.findById(request.getData().getId()).map(
                group -> {
                    group.setId(request.getData().getId());
                    group.setName(request.getData().getName());
                    if(request.getData().getDescription()!=null){
                    group.setDescription(request.getData().getDescription());}
                    Group newGroup=baseRepository.save(group);
                    return response(newGroup);
                }
        ).orElseGet(()->Header.ERROR("데이터 없음"));

    }

    @Override
    public Header delete(Long id) {
        return baseRepository.findById(id)
                .map(group -> {
                    baseRepository.delete(group);
                    return Header.OK();
                })
                .orElseGet(()->Header.ERROR("데이터 없음"));

    }

    public Header<GroupApiResponse> response(Group group){

        GroupApiResponse groupApiResponse=GroupApiResponse.builder()
                .id(group.getId())
                .name(group.getName())
                .description(group.getDescription())
                .build();

        return Header.OK(groupApiResponse);
    }
}
