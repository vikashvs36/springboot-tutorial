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

		Account account = accountService.getAccount("00001");
		System.out.println(account);

		/*Account account=null;
		Boolean isExistAccount = accountService.isExistAccount(account);*/

	}

}
