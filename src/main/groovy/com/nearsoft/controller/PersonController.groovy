package com.nearsoft.controller

import com.nearsoft.beans.Person
import com.nearsoft.service.PersonService

class PersonController {

    PersonService personService

    Person createPerson(name, phone){
        personService.createPerson(name, phone)
    }
}
