package com.lavanyaSpringBootProject.AOP_project.DAO;

import com.lavanyaSpringBootProject.AOP_project.Entity.Account;

import java.util.List;

public interface AccountDAO
{
    //add a new method findAccount()

    List<Account> findAccounts();

    public String getName() ;

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);

    void addAccount();

    boolean returnTrue();


    void addAccount(Account theAccount);

}
