package kr.co.contactproject.contact.respository;

import kr.co.contactproject.contact.model.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;

    //    Person person=Person.builder()
//            .name("박종연")
//            .age(26)
//            .birthday(LocalDate.of(1995,7,7))
//            .bloodType("B")
//            .phoneNumber("010-1111-111")
//            .build();
    @Test
    public void create() {
        Person person = Person.builder()
                .name("박종연")
                .age(26)
                .birthday(LocalDate.of(1995, 7, 7))
                .bloodType("B")
                .phoneNumber("010-1111-111")
                .createdAt(LocalDateTime.now())
                .createdBy("AdminJ")
                .build();

        Person newPerson = personRepository.save(person);
        System.out.println(newPerson);
    }

    @Test
    public void update() {
        Optional<Person> person = personRepository.findById(1L);
        person.ifPresent(
                newPerson -> {
                    newPerson.setAge(27);
                    newPerson.setUpdatedBy("AdminJ");
                    newPerson.setUpdatedAt(LocalDateTime.now());
                    personRepository.save(newPerson);
                });
    }

    @Test
    public void read(){
        Optional<Person> person=personRepository.findById(1L);
        person.ifPresent(
                newPerson -> {
                    System.out.println("이름: "+newPerson.getName());
                    System.out.println("나이: "+newPerson.getAge());
                    System.out.println("번호: "+newPerson.getPhoneNumber());
                }
        );
    }
    @Test
    public void delete(){
        Optional<Person> person=personRepository.findById(1L);
        person.ifPresent( p-> personRepository.delete(p)
        );
    }
}