package com.nearsoft.service

import com.nearsoft.beans.Person

class PersonService {

    Person create(name, phone){
        Person person = new Person()
        person.setName(name)
        person.setPhone(phone)
        person
    }
}
