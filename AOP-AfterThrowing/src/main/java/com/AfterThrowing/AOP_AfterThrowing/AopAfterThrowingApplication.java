package com.AfterThrowing.AOP_AfterThrowing;

import com.AfterThrowing.AOP_AfterThrowing.DAO.ExceptionDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopAfterThrowingApplication {

	public static void main(String[] args) {

		SpringApplication.run(AopAfterThrowingApplication.class, args);
	}
@Bean
	public CommandLineRunner commandLineRunner(ExceptionDAO exceptionDAO)
{
	return runner ->
	{
     afterThrow(exceptionDAO);
	};
}

	private void afterThrow(ExceptionDAO exceptionDAO)
	{

		try
		{
			System.out.println("\n Succesfull testing");
			System.out.println(exceptionDAO.divideNumber(20,4)+" : division");
		}
		catch (RuntimeException e)
		{
			System.out.println("exception occured: "+e);
		}
		try {
			System.out.println("\nTesting exception case:");
			exceptionDAO.divideNumber(20, 0);
		} catch (Throwable e) {
			System.out.println("Main: Exception = " + e);
		}


	}
}
