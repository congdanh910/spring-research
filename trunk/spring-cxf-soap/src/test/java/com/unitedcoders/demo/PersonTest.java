package com.unitedcoders.demo;


import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {

    @Test
    public void testPerson() {
        Person p = new Person("foo");
        assertEquals("foo", p.getName());
        
        p.setName("bar");
        assertEquals("bar", p.getName());
    }

}
