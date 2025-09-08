package com.lavanyaSpringBootProject.AOP_project;

import com.lavanyaSpringBootProject.AOP_project.DAO.AccountDAO;
import com.lavanyaSpringBootProject.AOP_project.DAO.MemberShipDAO;
import com.lavanyaSpringBootProject.AOP_project.Entity.Account;
import com.lavanyaSpringBootProject.AOP_project.Service.ServiceClass;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(AopProjectApplication.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MemberShipDAO theMembershipdao, ServiceClass serviceClass)
	{
		return runner ->
		{

            demoTheAfterReturnAdvie(theAccountDAO);

			//uncomment this to showcase pointcut expressions

			demoTheBeforeAdvice(theAccountDAO,theMembershipdao, serviceClass);
		};
	}
	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MemberShipDAO theMembershipdao,ServiceClass serviceClass) {
		//call the buisness method

		theAccountDAO.addAccount();

//	    //do it again
//
//		System.out.println("\n lets call the method once again");
//
//		theAccountDAO.addAccount();

		//call the member ship buisness method

		theMembershipdao.addAccountMembership();

		//method call

		System.out.println(theMembershipdao.returnNumber());

		System.out.println(theAccountDAO.returnTrue());

		//method of type paramter
		Account myaccount= new Account();
		theAccountDAO.addAccount(myaccount);

		//method that use point cut declaration
		System.out.println(serviceClass.chechTrue());
		System.out.println(serviceClass.returnSomething());
		serviceClass.PrintSomething();

		//call the getter setter method of account dao

		theAccountDAO.setName("lavanya");
		theAccountDAO.setServiceCode("silver");

		String name= theAccountDAO.getName();
		String code=theAccountDAO.getServiceCode();

		//Accesing method signature using joinpoints
		serviceClass.joinPointExample(10,20);


	}
//method for AfterRetruning advice

	private void demoTheAfterReturnAdvie(AccountDAO theAccountDAO) {
		List<Account> theAccounts = theAccountDAO.findAccounts();

		//display the accounts
		System.out.println("\n\n main program : demoTheAfterReturning advice");
		System.out.println("---------------------");

		System.out.println(theAccounts);

		System.out.println("\n");
		theAccountDAO.findAccounts();
	}




}






