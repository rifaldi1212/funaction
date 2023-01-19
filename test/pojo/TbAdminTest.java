/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ACER
 */
public class TbAdminTest {
    
    public TbAdminTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of login_user method, of class TbAdmin.
     */
    @Test
    public void testLoginAdmin() {
        System.out.println("login user admin");
        TbAdmin instance = new TbAdmin();
        instance.setUsername("admin");
        instance.setPassword("admin");
        String expResult = "success";
        String result = instance.login_user();
        System.out.println(expResult);
        System.out.println(result);
        assertEquals(expResult, result);
    }
}