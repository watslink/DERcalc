package com.sd.project.DERcalc;

import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    private Person person;
    @Test
    public void calcIMC() {
        this.person = new Person(false, 65, 90.5, 1.80);
        assertEquals(27.93, person.getIMC(),0.01);
    }

    @Test
    public void calcDERMJwithHommePlusDe59ans() {
        this.person = new Person(false, 65, 90.5, 1.80);
        assertEquals(7.32, person.getDERMJ(), 0.01);
    }

    @Test
    public void calcDERMJwithHommeMoinsDe60ans() {
        this.person = new Person(false, 55, 90.5, 1.80);
        assertEquals(0, person.getDERMJ(), 0.01);
    }

    @Test
    public void calcDERMJwithFemmePlusDe59ans() {
        this.person = new Person(true, 65, 81.5, 1.70);
        assertEquals(5.94, person.getDERMJ(), 0.01);
    }

    @Test
    public void calcDERMJwithFemmeEntre51et59Ans() {
        this.person = new Person(true, 55, 81.5, 1.70);
        assertEquals(6.31, person.getDERMJ(), 0.01);
    }

    @Test
    public void calcDERMJwithFemmeMoinsDe51ans() {
        this.person = new Person(true, 45, 81.5, 1.70);
        assertEquals(0, person.getDERMJ(), 0.01);
    }
    @Test
    public void calcDERkcal() {
        this.person = new Person(false, 65, 90.5, 1.80);
        assertEquals(1749.31, person.getDERkcal(), 0.01);
    }
}
