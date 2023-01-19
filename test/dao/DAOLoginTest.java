/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pojo.TbAdmin;

/**
 *
 * @author ACER
 */
public class DAOLoginTest {
    
    public DAOLoginTest() {
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
     * Test of getBy method, of class DAOLogin.
     */
    @Test
    public void testLogin() {
        System.out.println("getBy");
        String uName = "admin";
        String uPass = "amdin";
        DAOLogin instance = new DAOLogin();
        List<TbAdmin> result = instance.Login(uName, uPass);
        System.out.println(result.toArray().length);
    }
}
