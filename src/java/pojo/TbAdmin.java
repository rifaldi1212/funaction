package pojo;
// Generated Oct 14, 2022 1:53:41 AM by Hibernate Tools 4.3.1

import dao.DAOLogin;
import java.util.List;
import javax.faces.bean.ManagedBean;




/**
 * TbAdmin generated by hbm2java
 */
@ManagedBean
public class TbAdmin  implements java.io.Serializable {


     private String id;
     private String username;
     private String password;
     
     public String login_user(){
         DAOLogin uDao = new DAOLogin();
         List<TbAdmin> us = uDao.Login(username, password);
         try{
            if (us != null){
                username = us.get(0).username;
                password = us.get(0).password;
                return "success";
            }    
        }catch (Exception e){
            System.out.print(e);
        }
        return "gagal.xhtml";
     }
     
    public TbAdmin() {
    }

    public TbAdmin(String id, String username, String password) {
       this.id = id;
       this.username = username;
       this.password = password;
    }
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }




}


