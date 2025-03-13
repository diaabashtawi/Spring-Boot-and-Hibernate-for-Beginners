package com.bakeet.aop;

import com.bakeet.aop.model.Account;
import com.bakeet.aop.repository.AccountRepository;
import com.bakeet.aop.repository.MembershipRepository;
import com.bakeet.aop.service.impl.TrafficServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringBootAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAopApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AccountRepository accountRepository,
			MembershipRepository membershipRepository,
			TrafficServiceImpl trafficService
	) {
		return runner -> {
			/*
			beforeAvice(accountRepository, membershipRepository);
			afterReturningAdvice(accountRepository);
			afterThrowingAdvice(accountRepository);
			afterAdvice(accountRepository);
			getTrafficSerice(trafficService);
			aroundAdviceHandleRethrowException(trafficService);
			*/
			aroundAdviceHandleException(trafficService);





		};
	}

	private void aroundAdviceHandleRethrowException(TrafficServiceImpl trafficService) {
		System.out.println("Main Program : aroundAdviceHandleException");
		System.out.println("Calling aroundAdviceHandleException");
		boolean exceptionThrown = true;
		String traffic = trafficService.getTraffic(exceptionThrown);
		System.out.println("Traffic : " + traffic);
		System.out.println("Finished.");
	}

	private void aroundAdviceHandleException(TrafficServiceImpl trafficService) {
		System.out.println("Main Program : aroundAdviceHandleException");
		System.out.println("Calling aroundAdviceHandleException");
		boolean exceptionThrown = true;
		String traffic = trafficService.getTraffic(exceptionThrown);
		System.out.println("Traffic : " + traffic);
		System.out.println("Finished.");
	}

	private void getTrafficSerice(TrafficServiceImpl trafficService) {
		System.out.println("Main Program : getTrafficService");
		System.out.println("Calling getTrafficService");
		String traffic = trafficService.getTraffic();
		System.out.println("Traffic : " + traffic);
		System.out.println("Finished.");
	}

	private void afterAdvice(AccountRepository accountRepository) {
		List<Account> accounts = null;
		try{
			boolean vipFlag = false;
			accounts = accountRepository.findAccounts(vipFlag);
		}catch (Exception e) {
			System.out.println("After Throwing Advice caugth exception : " + e.getMessage());
		}
		System.out.println("-".repeat(250));
		System.out.println(accounts);
		System.out.println("-".repeat(250));
	}

	private void afterThrowingAdvice(AccountRepository accountRepository) {
		List<Account> accounts = null;
		try{
			boolean vipFlag = true;
			accounts = accountRepository.findAccounts(vipFlag);
		}catch (Exception e) {
			System.out.println("After Throwing Advice caugth exception : " + e.getMessage());
		}
		System.out.println("-".repeat(250));
		System.out.println(accounts);
		System.out.println("-".repeat(250));
	}

	private void afterReturningAdvice(AccountRepository accountRepository) {
		List<Account> accounts = accountRepository.findAccounts();
		System.out.println("Main Program: after returning advice ");
		System.out.println("-".repeat(250));
		System.out.println(accounts);
		System.out.println("-".repeat(250));
	}

	private void beforeAvice(AccountRepository accountRepository, MembershipRepository membershipRepository) {
		Account account = new Account();
		account.setFirstName("John");
		account.setLastName("Doe");
		accountRepository.createAccount(account, true);
		accountRepository.isAccountActive();
		accountRepository.setName("Deya Bakheet");
		accountRepository.setServiceCode("Gold");
		String name = accountRepository.getName();
		String serviceCode = accountRepository.getServiceCode();
		membershipRepository.createAccount();
		membershipRepository.isMembershipValid();
	}

}
