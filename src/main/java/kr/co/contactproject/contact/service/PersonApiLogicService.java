package kr.co.contactproject.contact.service;

import kr.co.contactproject.contact.model.entity.Person;
import kr.co.contactproject.contact.model.network.Header;
import kr.co.contactproject.contact.model.network.request.PersonApiRequest;
import kr.co.contactproject.contact.model.network.response.PersonApiResponse;
import kr.co.contactproject.contact.respository.GroupDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonApiLogicService extends BaseService<PersonApiRequest,PersonApiResponse,Person> {

    @Autowired
    private GroupDetailRepository groupDetailRepository;

    @Override
    public Header<PersonApiResponse> create(Header<PersonApiRequest> request) {

        PersonApiRequest body=request.getData();

        Person person= Person.builder()
                .name(body.getName())
                .age(body.getAge())
                .phoneNumber(body.getPhoneNumber())
                .bloodType(body.getBloodType())
                .birthday(body.getBirthday())
                .description(body.getDescription())
                .build();
        Person newPerson=baseRepository.save(person);


        return response(newPerson);
    }

    @Override
    public Header<PersonApiResponse> read(Long id) {
        return baseRepository.findById(id).map(person -> response(person))
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<PersonApiResponse> update(Header<PersonApiRequest> request) {

        PersonApiRequest body= request.getData();
        return baseRepository.findById(request.getData().getId())
                .map(
                        person -> {
                            person.setName(body.getName());
                            person.setAge(body.getAge());
                            person.setDescription(body.getDescription());
                            person.setBloodType(body.getBloodType());
                            person.setPhoneNumber(body.getPhoneNumber());
                            person.setBirthday(body.getBirthday());
                            return baseRepository.save(person);
                        }
                )
                .map(newPerson -> response(newPerson))
                .orElseGet(()-> Header.ERROR("데이터 없음"));

    }

    @Override
    public Header delete(Long id) {

        return baseRepository.findById(id)
                .map(person -> {
                    baseRepository.delete(person);
                    return Header.OK();})
                .orElseGet(()->Header.ERROR("데이터 없음"));

    }


    public Header<PersonApiResponse> response(Person person){

        PersonApiResponse personApiResponse=PersonApiResponse.builder()
                .id(person.getId())
                .age(person.getAge())
                .birthday(person.getBirthday())
                .bloodType(person.getBloodType())
                .description(person.getDescription())
                .name(person.getName())
                .phoneNumber(person.getPhoneNumber())
                .build();
        return Header.OK(personApiResponse);
    }

}
