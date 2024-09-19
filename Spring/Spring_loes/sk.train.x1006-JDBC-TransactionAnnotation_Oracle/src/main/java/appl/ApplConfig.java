package appl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import daos.AccountDao;
import daos.jdbc.AccountDaoImpl;
import services.AccountService;
import services.AccountServiceImpl;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement    //wichtig!!
public class ApplConfig {
	
	
	/* Datasource bereit stellen */

	@Value("classpath:create.sql")
	private Resource schemaScript;

	@Value("classpath:drop.sql")
	private Resource dropScript;
	
	
	private DataSource dataSource;

	// einfache DriverManagerDataSource nutzen
	@Bean
	public DataSource dataSource(@Value("${db.driver}") String driver, @Value("${db.url}") String url,
			@Value("${db.user}") String user, @Value("${db.password}") String pass) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(pass);
		this.dataSource = dataSource;
		return dataSource;
	}

	@Bean
	@Autowired
	public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {
		final DataSourceInitializer initializer = new DataSourceInitializer();
		initializer.setDataSource(dataSource);
		initializer.setDatabasePopulator(databasePopulator());
		//initializer.setDatabaseCleaner(databaseCleaner());
		return initializer;
	}

	
	private DatabasePopulator databasePopulator() {
		final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(schemaScript);
		populator.setIgnoreFailedDrops(true);
		return populator;
	}	
	

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(this.dataSource);
	}
	
		
	@Bean 
	public AccountDao accountDao() {
		final AccountDaoImpl dao = new AccountDaoImpl();
		dao.setDataSource(this.dataSource);
		return dao;
	}
	
	@Bean 
	public AccountService accountService() {
		return new AccountServiceImpl(this.accountDao());
	}
}
