package com.lavanyaSpringBootProject.AOP_project.DAO;

import com.lavanyaSpringBootProject.AOP_project.Entity.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements  AccountDAO{

    private String name;
    private String serviceCode;


    @Override
    public List<Account> findAccounts()
    {
        List<Account> myAccounts = new ArrayList<>();

        //creating sample accounts
         Account temp1=new Account("john", "silver");
         Account temp2 = new Account("jonny","silver");
         Account temp3 =new Account("kate","gold");

         //adding sample accounts
         myAccounts.add(temp1);
         myAccounts.add(temp2);
         myAccounts.add(temp3);

        //create sample accoounts and dd them to the list

        return  myAccounts;

    }

    @Override
    public String getName() {
        System.out.println(getClass() +" get Name");
        return name;
    }

    @Override
    public void setName(String name)
    {
        System.out.println(getClass() +"set name");
        this.name = name;
    }

    @Override
    public String getServiceCode() {
        System.out.println(getClass() +" get service code");
        return serviceCode;
    }

   @Override
    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() +" set service code");
        this.serviceCode = serviceCode;
    }

    @Override
    public void addAccount()
    {
        System.out.println(getClass()+" : Doing my database work adding an acoount");
    }


    @Override
    public boolean returnTrue()
    {
        return true;
    }

    @Override
    public void addAccount(Account theAccount) {
        System.out.println("\n======>>>> Account retunred");
    }

}
