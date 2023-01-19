/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pojo.User;

/**
 *
 * @author Asus
 */
public class UserBeanTest {
    
    public UserBeanTest() { 
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

   
    @Test
    public void testDataUser() {
        System.out.println("getUsers");
        UserBean instance = new UserBean();
        int expResult = 4;
        List<User> result = instance.getUsers();
        assertEquals(expResult, result.toArray().length);
       
    }
    
    @Test
    public void testaddUser() {
        System.out.println("Test Add User");
    
        User instance = new User();
        instance.setId(Integer.SIZE);
        instance.setRecordNo(String.valueOf(Character.SIZE));
        instance.setNama("Muhammad Rifaldi Fauzan Ambara Arsyi");
        instance.setEmail("MRFAA12@gmail.com");
        instance.setjumlahtiket(Integer.valueOf(1));
        instance.setTanggal(Date.valueOf(LocalDate.of(2022, 10, 01)));
    
        String expResult = "index";
        String result = instance.addUser();

        assertEquals(expResult, result);
    }
   


   
    @Test
    public void testEditUser() {
        System.out.println("EditUser");
        User instance = new User();
        instance.setId(2);
        instance.setRecordNo(String.valueOf(2));
        instance.setNama("Muhammad Rifaldi Fauzan Ambara Arsyi Bayu");
        instance.setEmail("MRFAA12@gmail.com");
        instance.setjumlahtiket(Integer.valueOf(1));
        instance.setTanggal(Date.valueOf(LocalDate.of(2022, 10, 01)));
        
        String expResult = "search";
        String result = instance.updateUser();

        assertEquals(expResult, result);
    }

    
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        User instance = new User();
        instance.setId(1);
        String expResult = "search";
        String result = instance.deleteUser();

        assertEquals(expResult, result);
    }    
}
