package com.example.user.mymanillas;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void prueba1() throws Exception{
        assertEquals(80, Metodos.tipo_tipo(1),0);
    }
    @Test
    public void prueba2() throws Exception{
        assertEquals(90, Metodos.tipo_tipo2(2),0);
    }
    @Test
    public void prueba3() throws Exception{
        assertEquals(90, Metodos.tipo_tipo3(0),0);
    }
    @Test
    public void prueba4() throws Exception{
        int j = Metodos.tipo_tipo4(1);
        assertEquals(90, j,0);
    }
}