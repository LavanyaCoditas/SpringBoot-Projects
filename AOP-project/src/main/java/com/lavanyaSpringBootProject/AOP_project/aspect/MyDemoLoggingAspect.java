package com.lavanyaSpringBootProject.AOP_project.aspect;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lavanyaSpringBootProject.AOP_project.Entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Aspect
@Component
public class MyDemoLoggingAspect
{
    // this is where we add all of our related advices for logging

    //@Before advice
    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice()
    {
        System.out.println("\n+============>>>>>>> executing before the method addAccount()  ");
    }

    //pointcut expression to match with eaxctly the method of specific class
    @Before("execution(public void com.lavanyaSpringBootProject.AOP_project.AccountDAO.addAccount())")
    public void specificToAddAccountInAccountDAO()
    {
        System.out.println("\nspecific to account DAO method pointcut expression");
    }


    //pointcut Expression to match any method that start with "add" in its name
    @Before("execution(public void add*())")
    public void executeBeforeMethodsStartngWithAdd()
    {

        System.out.println("\nthis is the method that starts with add in its name ");
    }


    //method with any return type and method starting with return in its name
    @Before("execution(* return*())")
    public void anyReturnType()
    {
        System.out.println("\nmy method of any return type");
    }


    //method with account as parameter
    @Before("execution(* add*(com.lavanyaSpringBootProject.AOP_project.Entity.Account)")
    public void paramMethod()
    {
        System.out.println("\nmethod with the parameter type of Account");
    }


    //Display the method signature using Join-point


    @Before("execution(* com.lavanyaSpringBootProject.AOP_project.Service.*.join*(..))")
    public void joinPointExample(JoinPoint joinPoint)
    {
        //method signature
        MethodSignature methodSignature= (MethodSignature)joinPoint.getSignature();
        System.out.println(methodSignature+": method\n");

        //get the method arguments
        Object[] args= joinPoint.getArgs();

        //loop through the arguments
         for(Object tempargs : args)
         {
             System.out.print(tempargs+"  ");

         }
        System.out.println();
     }

     //Add a new advice for @AfterReturning on the findAccounts methpd

    @AfterReturning(
            pointcut = "execution( * com.lavanyaSpringBootProject.AOP_project.DAO.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public  void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result)
    {
        //print out which method we are advising on
        String method= joinPoint.getSignature().toShortString();
        System.out.println("======>>>>> executing @AfterReturning on method: "+method);


        //print the results of the method call
        System.out.println("========>>>>> result"+result);


        //modify the return data
        convertAccountNamesToUpperCASE( result);

        //after modification printing
        System.out.println("========>>>>> result :"+result);


    }

    private void convertAccountNamesToUpperCASE(  List<Account> result) {

        //loop thrugh the accounts
        for(Account tempAccounts : result)
        {
            //get uppercase version of account name
            String theUpperName = tempAccounts.getName().toUpperCase();

            //update the name on the account
           tempAccounts.setName(theUpperName);
        }
    }


}
