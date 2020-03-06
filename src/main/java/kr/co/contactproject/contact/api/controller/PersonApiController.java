package kr.co.contactproject.contact.api.controller;

import kr.co.contactproject.contact.ifs.CrudInterface;
import kr.co.contactproject.contact.model.entity.Person;
import kr.co.contactproject.contact.model.network.Header;
import kr.co.contactproject.contact.model.network.request.PersonApiRequest;
import kr.co.contactproject.contact.model.network.response.PersonApiResponse;
import kr.co.contactproject.contact.service.PersonApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/person")
public class PersonApiController implements CrudInterface<PersonApiRequest, PersonApiResponse> {
    @Autowired
    private PersonApiLogicService personApiLogicService;

    @PostMapping("")
    @Override
    public Header<PersonApiResponse> create(@RequestBody Header<PersonApiRequest> request) {
        return personApiLogicService.create(request);
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
}
