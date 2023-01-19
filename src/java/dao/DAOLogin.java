/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.*;
import org.hibernate.*;
import pojo.*;

/**
 *
 * @author Bayu & Arsyi
 */
public class DAOLogin {
    public List<TbAdmin> Login(String uName, String uPass){
        Transaction trans  = null;
        TbAdmin us = new TbAdmin();
        List<TbAdmin> user = new ArrayList();
        
         Session session = funactionUtil.getSessionFactory().openSession();
         try{
             trans = session.beginTransaction();
             Query query = session.createQuery("from TbAdmin where username=:uName AND password=:uPass ");
             query.setString("uName", uName);
             query.setString("uPass", uPass);
             us = (TbAdmin) query.uniqueResult();
             user = query.list();
             trans.commit();
         }
         catch (Exception e){
              System.out.println(e);
         } 
         return user;
    }
}
