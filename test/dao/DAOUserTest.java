/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.time.LocalDate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static org.junit.Assert.*;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pojo.User;
import pojo.funactionUtil;

/**
 *
 * @author ACER
 */
public class DAOUserTest {
    
    public DAOUserTest() {
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
     * Test of SearchByRecordNo method, of class DAOUser.
     */
    @Test
    public void testSearchByRecordNo() {
        System.out.println("SearchByRecordNo");
        String RecordNo = "1";
        DAOUser instance = new DAOUser();
        List<User> result = instance.SearchByRecordNo(RecordNo);
        assertThat(result, is(notNullValue()));
    }    

    /**
     * Test of add method, of class DAOUser.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        
        User newuser = new User();
        newuser.setId(Integer.SIZE);
        newuser.setRecordNo(String.valueOf(Character.SIZE));
        newuser.setNama("Fauzan lulu");
        newuser.setTanggal(Date.valueOf(LocalDate.of(2022, 10, 01)));
        newuser.setjumlahtiket(2);
        newuser.setEmail("fauzan12@gmail.com");
        
        DAOUser instance = new DAOUser();
        instance.add(newuser);
        assertNotNull(newuser);
    }

    /**
     * Test of delete method, of class DAOUser.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        User newuser = new User();
        int Id = 3;
        DAOUser instance = new DAOUser();
        Transaction transaction = null;
        Session session = funactionUtil.getSessionFactory().openSession();

        transaction = session.beginTransaction();
        instance.delete(newuser);
        transaction.commit();

        User user;
        user = (User) session.get(User.class, Id);
    }

    /**
     * Test of update method, of class DAOUser.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        User newuser = new User();
        DAOUser instance = new DAOUser();
        Transaction transaction = null;
        Session session = funactionUtil.getSessionFactory().openSession(); 
        
        Integer id = 2;
        newuser.setId(id);
        newuser.setNama("Fadila Hasibuan");
        newuser.setTanggal(Date.valueOf(LocalDate.of(2022, 10, 01)));
        newuser.setjumlahtiket(5);
        newuser.setEmail("fadilahs@gmail.com");
        
        transaction = session.beginTransaction();
        instance.update(newuser);
        transaction.commit();
        
        User updateUser = (User) session.get(User.class, id);
    }
    
}
