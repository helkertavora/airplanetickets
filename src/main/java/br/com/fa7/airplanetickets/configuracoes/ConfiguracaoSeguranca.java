/*package br.com.fa7.airplanetickets.configuracoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.fa7.airplanetickets.modelo.servicos.ServicoAutenticacao;

@Configuration
@EnableWebSecurity
public class ConfiguracaoSeguranca extends WebSecurityConfigurerAdapter{
	
	@Autowired private ServicoAutenticacao servicoAutenticacao;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.inMemoryAuthentication().withUser("admin").password("admin").roles("PIZZARIA");
		
		auth.userDetailsService(servicoAutenticacao);   //.passwordEncoder(encoder());
	}
	@Bean
	public BCryptPasswordEncoder encoder(){
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/pizzas/**", "/pizzarias/**", "/clientes/**", "/ingredientes/**").hasRole("PIZZARIA")
		.anyRequest().permitAll().and().formLogin().loginPage("/login").loginProcessingUrl("/autenticar")
		.defaultSuccessUrl("/pizzas").failureUrl("/login?semacesso=true")
		.usernameParameter("usuario").passwordParameter("senha")
		.and().logout().logoutUrl("/sair").logoutSuccessUrl("/login?saiu=true");
	}

}
*/