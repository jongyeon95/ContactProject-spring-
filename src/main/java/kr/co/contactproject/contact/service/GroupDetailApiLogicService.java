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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupDetailApiLogicService
        extends BaseService<GroupDetailApiRequest, GroupDetailApiResponse, GroupDetail> {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Override
    public Header<GroupDetailApiResponse> create(Header<GroupDetailApiRequest> request) {
        GroupDetailApiRequest body=request.getData();
        GroupDetail groupDetail=GroupDetail.builder()
                .group(groupRepository.getOne(body.getGroupId()))
                .person(personRepository.getOne(body.getPersonId()))
                .build();
        GroupDetail newGroupDetail=baseRepository.save(groupDetail);
        return response(newGroupDetail);




    }

    @Override
    public Header<GroupDetailApiResponse> read(Long id) {

        return baseRepository.findById(id).map(groupDetail -> {
            GroupDetail newGroupDetail= GroupDetail.builder()
                    .id(groupDetail.getId())
                    .group(groupDetail.getGroup())
                    .person(groupDetail.getPerson())
                    .build();
            return response(newGroupDetail);
        }
        ).orElseGet(()->Header.ERROR("데이터 없음"));
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
                .groupName(groupDetail.getGroup().getName())
                .personName(groupDetail.getPerson().getName())
                .build();
        return Header.OK(groupDetailApiResponse);
    }
}
