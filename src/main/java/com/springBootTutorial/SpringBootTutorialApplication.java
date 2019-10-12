package com.springBootTutorial;


import com.springBootTutorial.modal.Account;
import com.springBootTutorial.service.AccountServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootTutorialApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(SpringBootTutorialApplication.class);

		AccountServiceImpl accountService = (AccountServiceImpl) applicationContext.getBean("accountServiceImpl", AccountServiceImpl.class);

		accountService.updateAccountBalance(new Account("00001", 1000.0), 500.00);
	}

}
