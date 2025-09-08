package com.AOP.AfterFinally;

import com.AOP.AfterFinally.DAO.CalculatorDAO;
import com.AOP.AfterFinally.Service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AfterFinallyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AfterFinallyApplication.class, args);
	}
@Bean
	CommandLineRunner commandLineRunner(CalculatorDAO calculatorDAO, TrafficFortuneService trafficFortuneService)
{
	return runner ->
	{
		//executes the After advice
		  theAfterAdvice(calculatorDAO);

		  //executes around advice

		  theFortuneService(trafficFortuneService);


		  demoTheAroundAdvice(trafficFortuneService);
	};
}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {

		System.out.println("\n main program: demo around advice for exception simulation ");
		boolean tripwire = true;
		System.out.println("my Fortune is : "+trafficFortuneService.getFortune(tripwire));

	}

	private void theFortuneService(TrafficFortuneService trafficFortuneService)
	{
		System.out.println("\n main program: demo around advice");
		System.out.println("my Fortune is : "+trafficFortuneService.getFortune());

	}

	private void theAfterAdvice(CalculatorDAO calculatorDAO) {
		try {
			calculatorDAO.divide(20, 10);

			calculatorDAO.divide(9, 0);
			calculatorDAO.multiply(10, 29);
			System.out.println("methods executed succesfulyy");
		}
		catch(Throwable e)
		{

		}
	}


}
