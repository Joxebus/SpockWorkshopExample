package com.nearsoft.test

import com.nearsoft.beans.Person
import com.nearsoft.controller.PersonController
import com.nearsoft.service.PersonService
import spock.lang.Specification
import spock.lang.Unroll

/**
 * This test is designed to validate the creation of a Person bean
 */
class PersonSpec extends Specification{

    PersonController personController
    PersonService personService

    def setup(){
        personService = Mock()
        personController = new PersonController(
                personService: personService
        )
    }

    def "Test Mocking Service calls"(){
        given: "A name and a phone"
        List params = ["Omar","423-652-8724"]
        //String name = "Omar"
        //String phone = "423-652-8724"

        when: "A person is created by the Controller"
        personController.create(*params)

        then: "The service must be called"
        1 * personService.create(_,_)
    }



    @Unroll("Testing with name #name and #phone")
    def "Test valid telephones"(){
        given: "A person"
        Person person = new Person()

        when: "Set values to test the person"
        //println "Testing with name:$name and phone:$phone"
        person.setName(name)
        person.setPhone(phone)

        then: "The phone must match with the regex"
        person.phone ==~ /(\d{3})-(\d{3})-(\d{4})/

        where:
        name    | phone
        'Amaia' | "442-123-4560"
        'Jorge' | "662-6534567"
        'David' | "415-345-4568"
        'Diego' | "442-123-4569"

    }

    //@Unroll
    def "Test invalid telephones"(){
        when:
        println "Testing with name:$name and phone:$phone"
        Person person = new Person()
        person.setName(name)
        person.setPhone(phone)

        then:
        thrown RuntimeException

        where:

        phone << ["442-12345-60", "662653-4567", "415-345--4568", "(442)-1234569"]
        name << ['Amaia', 'Jorge', 'David', 'Diego']

    }

    @Unroll
    def "Test @Canonical methods"(){
        when: "Create 2 Person instance with values: "
        Person p1 = new Person()
        p1.with {
            name = name1
            phone = phone1
        }

        Person p2 = new Person()
        p2.with {
            name = name2
            phone = phone2
        }

        println "Person 1: $p1"
        println "Person 2: $p2"

        then:
        ( p1.hashCode() == p2.hashCode() )  == expected
        ( p1.equals(p2) )                   == expected
        ( p1.toString() == p2.toString() )  == expected

        where: "values for test cases."
        name1   | phone1            | name2   | phone2          || expected
        'Amaia' | "442-123-4560"    | 'Amaia' | "442-123-4560"  || true
        'Jorge' | "662-653-4567"    | 'Omar'  | "662-653-4567"  || true
        'David' | "415-345-4568"    | 'David' | "415-345-4568"  || true
        'Diego' | "442-123-4569"    | 'DIEGO' | "442-123-4569"  || false

    }



}
