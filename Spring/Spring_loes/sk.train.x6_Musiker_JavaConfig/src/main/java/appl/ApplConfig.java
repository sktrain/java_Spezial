package appl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

import beans.Gitarre;
import beans.Klavier;
import beans.Musiker;
import ifaces.Instrument;
import ifaces.Performer;

@Configuration
public class ApplConfig {
	
	public ApplConfig() {
		//Log.log();
	}
	
	@Bean(name="gitarre")
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Instrument getGitarre() {
		//Log.log();
		return new Gitarre();
	}
	
	@Bean(name="klavier")
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Instrument getKlavier() {
		//Log.log();
		return new Klavier();
	}

	@Bean(name="klavierspieler")
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Performer getKlavierSpieler() {
		//Log.log();
		return new Musiker(this.getKlavier());
	}
	
	@Bean(name="gitarist")
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Performer getGitarist() {
		//Log.log();
		return new Musiker(this.getGitarre());
	}
	
	
}
