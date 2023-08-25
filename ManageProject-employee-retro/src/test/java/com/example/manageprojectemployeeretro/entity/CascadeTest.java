//package com.example.manageprojectemployeeretro.entity;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//import org.junit.jupiter.api.*;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.time.LocalDate;
//import java.util.Arrays;
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class CascadeTest {
//    @Mock
//    private Session session;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//        // Cấu hình các hành vi giả lập cho session nếu cần thiết
//    }
////CascadeType.PERSIST
//    @Test
//    public void whenParentSavedThenChildSaved() {
//        Person person = new Person();
//        Address address = new Address();
//        address.setPerson(person);
//        person.setAddresses(Arrays.asList(address));
//        session.persist(person);
//        session.flush();
//        session.clear();
//    }
////    CascadeType.MERGE
//    @Test
//    public void whenParentSavedThenMerged() {
//        int addressId;
//        Person person = buildPerson("devender");
//        Address address = buildAddress(person);
//        person.setAddresses(Arrays.asList(address));
//        session.persist(person);
//        session.flush();
//        addressId = address.getId();
//        session.clear();
//
//        Address savedAddressEntity = session.find(Address.class, addressId);
//        Person savedPersonEntity = savedAddressEntity.getPerson();
//        savedPersonEntity.setName("devender kumar");
//        savedAddressEntity.setHouseNumber(24);
//        session.merge(savedPersonEntity);
//        session.flush();
//    }
//
////    Cascage remove
//    @Test
//    public void whenParentRemovedThenChildRemoved() {
//        int personId;
//        Person person = buildPerson("devender");
//        Address address = buildAddress(person);
//        person.setAddresses(Arrays.asList(address));
//        session.persist(person);
//        session.flush();
//        personId = person.getId();
//        session.clear();
//
//        Person savedPersonEntity = session.find(Person.class, personId);
//        session.remove(savedPersonEntity);
//        session.flush();
//    }
////    CascadeType.DETACH
//    @Test
//    public void whenParentDetachedThenChildDetached() {
//        Person person = buildPerson("devender");
//        Address address = buildAddress(person);
//        person.setAddresses(Arrays.asList(address));
//        session.persist(person);
//        session.flush();
//
//        assertThat(session.contains(person)).isTrue();
//        assertThat(session.contains(address)).isTrue();
//
//        session.detach(person);
//        assertThat(session.contains(person)).isFalse();
//        assertThat(session.contains(address)).isFalse();
//    }
//    private Person buildPerson(String name) {
//        Person person = new Person();
//        person.setName(name);
//        return person;
//    }
//    private Address buildAddress(Person person) {
//        Address address = new Address();
//        address.setPerson(person);
//        // Thiết lập các thuộc tính khác của đối tượng Address nếu cần thiết
//        return address;
//    }
//
//}
