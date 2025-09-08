package com.AOP.AfterFinally.Service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements  TrafficFortuneService{
    @Override
    public String getFortune()
    {
        //simulate a delay
      try {
               TimeUnit.SECONDS.sleep(5);
          }
      catch (Exception e) {throw new RuntimeException( e);}

        //return a fortune

        return "Expect Heavy Traffic this evening";
    }

    @Override
    public String getFortune(boolean tripwire)
    {
        if(tripwire)
        {
            throw new RuntimeException("The trip wire is true so exception occures");
        }

        return"except load shading ";
    }

}
