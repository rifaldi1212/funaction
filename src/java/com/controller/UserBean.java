/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.controller;  
import javax.faces.bean.*;  
import java.util.*;  
import dao.DAOUser;  
import pojo.User;  
import java.io.Serializable;  
import org.primefaces.event.RowEditEvent;  
import javax.faces.context.FacesContext;  
import javax.faces.application.FacesMessage;  
import org.primefaces.context.RequestContext; 

/**
 *
 * @author Bayu & Arsyi
 */

@ManagedBean(name = "userBean")  
@ViewScoped  
public class UserBean implements Serializable  
{  
    private List < User > usersList;  
    private List < User > searchList;  
    private List < User > searchByRecordNoList;  
    DAOUser userDao = new DAOUser();  
    User user = new User();  
    User newuser = new User();
    
    public List < User > getUsers()  
    {  
        usersList = userDao.AllUsers();  
        int count = usersList.size();  
        return usersList;  
    }  
    
    public void addUser()  
    {  
        String Email = newuser.getEmail();  
        Integer userId = 0;  
        userId = userDao.getId();  
        newuser.setId(userId);  
        String Id = Integer.toString(newuser.getId());  
        newuser.setRecordNo(Integer.toString(userId));  
        userDao.add(newuser);  
        System.out.println("User successfully saved.");  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Save Information", "User successfully saved.");  
        RequestContext.getCurrentInstance().showMessageInDialog(message);  
        newuser = new User();  
    }  
    
    public void changeUser(User user)  
    {  
        this.user = user;  
    }  
    
    public void UpdateUser(User user)  
    {  
        String Nama = user.getNama();  
        FacesMessage message1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Nama", Nama);  
        RequestContext.getCurrentInstance().showMessageInDialog(message1);  
        userDao.update(user);  
        System.out.println("User Info successfully saved.");  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Save Information", "User updated successfully .");  
        RequestContext.getCurrentInstance().showMessageInDialog(message);  
        user = new User();  
    }  
    
    public void deleteUser(User user)  
    {  
        String Nama = user.getNama();  
        //FacesMessage message3= new FacesMessage(FacesMessage.SEVERITY_INFO, "Delete Item",contactName);  
        // RequestContext.getCurrentInstance().showMessageInDialog(message3);  
        userDao.delete(user);  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Delete", "Record deleted successfully");  
        RequestContext.getCurrentInstance().showMessageInDialog(message);  
    }  
    
    public void searchbyRecordno()  
    {  
        searchByRecordNoList = userDao.SearchByRecordNo(user.getRecordNo());  
        int count = searchByRecordNoList.size();  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Number of Record Selected:", Integer.toString(count));  
        RequestContext.getCurrentInstance().showMessageInDialog(message);  
    }  
    
    public User getUser()  
    {  
        return user;  
    }  
    
    public void setUser(User user)  
    {  
        this.user = user;  
    }  
    
    public User getNewuser()  
    {  
        return newuser;  
    }  
    
    public void setNewuser(User newuser)  
    {  
        this.newuser = newuser;  
    }  
    public List < User > getUsersList()  
    {  
        return usersList;  
    } 
    
    public void setUsersList(List < User > usersList)  
    {  
        this.usersList = usersList;  
    } 
    
    public List < User > getSearchList()  
    {  
        return searchList;  
    } 
    
    public void setSearchList(List < User > searchList)  
    {  
        this.searchList = searchList;  
    } 
    
    public List < User > getSearchByRecordNoList()  
    {  
        return searchByRecordNoList;  
    }  
    
    public void setSearchByRecordNoList(List < User > searchByRecordNoList)  
    {  
        this.searchByRecordNoList = searchByRecordNoList;  
    }  
    
    public void onRowEdit(RowEditEvent event)  
    {  
        FacesMessage msg = new FacesMessage(" Edited Record No", ((User) event.getObject()).getRecordNo());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        User editeduser = (User) event.getObject();  
        userDao.update(editeduser);  
    }  
    
    public void onCancel(RowEditEvent event)  
    {  
        FacesMessage msg = new FacesMessage("Edit Cancelled");  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        usersList.remove((User) event.getObject());  
    }  
}  
