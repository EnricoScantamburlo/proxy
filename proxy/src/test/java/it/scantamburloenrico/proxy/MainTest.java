/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.scantamburloenrico.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Enrico Scantamburlo <scantamburlo at streamsim.com>
 */
public class MainTest {

    @Test(expected = IllegalArgumentException.class)
    public void testSomeMethod() {
        InvocationHandler h = (Object proxy, Method method, Object[] args1) -> {
            switch (method.getName()) {
                case "getName":
                    return "Enrico";
                case "getAge":
                    return 36;
                case "getJob":
                    throw new IllegalArgumentException(method.getName() + " is not supported");
            }

            throw new UnsupportedOperationException("Not supported yet.");
        };

        Person p = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, h);

        assertEquals("Enrico", p.getName());
        assertEquals(36, p.getAge());

        // Method test
        assertEquals("Hello Enrico!", Main.cheer(p));

        // It throws an exception here because the method was not implemented
        assertEquals("Programmer", p.getJob());
    }

}
