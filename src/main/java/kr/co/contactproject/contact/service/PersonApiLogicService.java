package kr.co.contactproject.contact.service;

import kr.co.contactproject.contact.ifs.CrudInterface;
import kr.co.contactproject.contact.model.entity.Person;
import kr.co.contactproject.contact.model.network.Header;
import kr.co.contactproject.contact.model.network.request.PersonApiRequest;
import kr.co.contactproject.contact.model.network.response.PersonApiResponse;
import kr.co.contactproject.contact.respository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonApiLogicService implements CrudInterface<PersonApiRequest, PersonApiResponse> {

    @Autowired
    private PersonRepository personRepository;

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
                .groupDetailList(body.getGroupDetailList())
                .build();
        Person newPerson=personRepository.save(person);


        return response(newPerson);
    }

    @Override
    public Header<PersonApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<PersonApiResponse> update(Header<PersonApiRequest> request) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        return null;
    }


    public Header<PersonApiResponse> response(Person person){

        PersonApiResponse personApiResponse=PersonApiResponse.builder()
                .id(person.getId())
                .age(person.getAge())
                .birthday(person.getBirthday())
                .bloodType(person.getBloodType())
                .description(person.getDescription())
                .groupDetailList(person.getGroupDetailList())
                .name(person.getName())
                .phoneNumber(person.getPhoneNumber())
                .build();
        return Header.OK(personApiResponse);
    }

}
