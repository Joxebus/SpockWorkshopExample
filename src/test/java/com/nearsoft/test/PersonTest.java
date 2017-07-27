package com.nearsoft.test;

import com.nearsoft.beans.Person;
import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PersonTest {

    private static final String PHONE_REGEX = "(\\d{3})-(\\d{3})-(\\d{4})";

    @Test
    public void testValidNumber(){
        String name = "Amaia";
        String phone = "442-123-4560";
        Person person = new Person();
        person.setName(name);
        person.setPhone(phone);

        assertTrue(Pattern.matches(PHONE_REGEX, person.getPhone()));
        assertEquals(name, person.getName());
    }

    @Test
    public void testInvalidNumber(){
        String name = "Jorge";
        String phone = "442123-4560";
        try{
            Person person = new Person();
            person.setName(name);
            person.setPhone(phone);
        }catch(RuntimeException e){
            assertEquals(String.format("%s has an invalid format ###-###-####", phone), e.getMessage());
        }
    }

    @Test
    public void testPersonGeneratesSameHashCode(){
        String name = "Amaia";
        String phone = "442-123-4560";

        Person person1 = new Person();
        person1.setName(name);
        person1.setPhone(phone);

        Person person2 = new Person();
        person2.setName(name);
        person2.setPhone(phone);

        assertEquals(name, person1.getName());
        assertEquals(name, person2.getName());
        assertEquals(phone, person1.getPhone());
        assertEquals(phone, person2.getPhone());

        assertEquals(person1.hashCode(), person2.hashCode());
    }

    @Test
    public void testPersonGeneratesDifferentHashCode(){
        String name1 = "Amaia";
        String phone1 = "442-123-4560";
        String name2 = "Jorge";
        String phone2 = "442-523-4763";

        Person person1 = new Person();
        person1.setName(name1);
        person1.setPhone(phone1);

        Person person2 = new Person();
        person2.setName(name2);
        person2.setPhone(phone2);

        assertFalse(person1.hashCode() == person2.hashCode());
    }

}
