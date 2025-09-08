package com.lavanyaSpringBootProject.AOP_project.Service;

import org.springframework.stereotype.Service;

@Service
public class ServiceClass
{
    public void PrintSomething()
    {
        System.out.println("something");
    }
    public int returnSomething()
    {
        return 2004;
    }
    public boolean chechTrue()
    {
    return true;
    }


    public void joinPointExample( int a, int b)
    {
        System.out.println("just an example");
    }





}
