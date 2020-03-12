package kr.co.contactproject.contact.service;

import kr.co.contactproject.contact.model.entity.Group;
import kr.co.contactproject.contact.model.entity.GroupDetail;
import kr.co.contactproject.contact.model.entity.Person;
import kr.co.contactproject.contact.model.network.Header;
import kr.co.contactproject.contact.model.network.request.GroupApiRequest;
import kr.co.contactproject.contact.model.network.request.GroupDetailApiRequest;
import kr.co.contactproject.contact.model.network.response.GroupDetailApiResponse;
import kr.co.contactproject.contact.respository.GroupRepository;
import kr.co.contactproject.contact.respository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupDetailApiLogicService
        extends BaseService<GroupDetailApiRequest, GroupDetailApiResponse, GroupDetail> {
    private PersonRepository personRepository;
    private GroupRepository groupRepository;
    @Override
    public Header<GroupDetailApiResponse> create(Header<GroupDetailApiRequest> request) {






        return null;
    }

    @Override
    public Header<GroupDetailApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<GroupDetailApiResponse> update(Header<GroupDetailApiRequest> request) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        return null;
    }

    public Header<GroupDetailApiResponse> response(GroupDetail groupDetail){
        GroupDetailApiResponse groupDetailApiResponse=GroupDetailApiResponse.builder()
                .id(groupDetail.getId())
                .group(groupDetail.getGroup())
                .person(groupDetail.getPerson())
                .build();
        return Header.OK(groupDetailApiResponse);
    }
}
