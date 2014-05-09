package com.unitedcoders.demo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PersonServiceImplTest {

    private PersonService service;
    
    @Before
    public void setUp() {
        service = new PersonServiceImpl();
    }
    
    @Test
    public void testGreetPerson() {
        String expected = "Hello World!";
        
        String actual = service.greetPerson("World");
        
        assertEquals(expected, actual);
    }
    
}
