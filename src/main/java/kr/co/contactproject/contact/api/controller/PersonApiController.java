package kr.co.contactproject.contact.api.controller;


import kr.co.contactproject.contact.model.entity.Person;
import kr.co.contactproject.contact.model.network.request.PersonApiRequest;
import kr.co.contactproject.contact.model.network.response.PersonApiResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/person")
public class PersonApiController
        extends CrudApiController<PersonApiRequest, PersonApiResponse,Person> {

}
