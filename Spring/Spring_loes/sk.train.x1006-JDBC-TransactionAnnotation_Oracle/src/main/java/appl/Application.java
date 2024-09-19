package appl;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import domain.Account;
import services.AccountService;

public class Application {
	public static void main(String[] args) {
		
		try (final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("appl")) {
			final AccountService accountService = ctx.getBean(AccountService.class);
			System.out.println(accountService.getClass().getName());
			accountService.createAccount(4711);
			accountService.createAccount(4712);
			accountService.deposit(4711, 5000);
			accountService.deposit(4712, 6000);
			accountService.withdraw(4711, 2000);
			try {
				accountService.transfer(4711, 4712, 500000);
			}
			catch (final Exception e) {
				System.out.println(e);
			}
			final List<Account> list = accountService.findAllAccounts();
			list.forEach(System.out::println);
		}
	}

}
