package com.upe.alide.webSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
public class ConfiguracaoRequisicoes extends WebSecurityConfigurerAdapter{
	
	@Autowired
	implementsUserDetailsService userDetailsService;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/quiz", "/quiz.html").hasAnyAuthority("ROLE_ALUN","ROLE_COORD", "ROLE_PROF")
			.antMatchers("/dashboard", "/dashboard.html").hasRole("ALUN")
			.antMatchers("/dash-professor", "/dash-professor.html").hasRole("PROF")
			.antMatchers("/desafios", "/desafios.html", "/jogos", "/jogos.html", 
					"perfil", "perfil.html").authenticated()
			.antMatchers("/add-desafio", "/add-desafio.html")
				.hasAnyAuthority("ROLE_COORD", "ROLE_PROF")
			.antMatchers("/excluir").hasAnyAuthority("ROLE_PROF", "ROLE_COORD")
			.antMatchers("/cadastro", "confirm-cadastro").hasAnyAuthority("ROLE_PROF", "ROLE_COORD")
			.anyRequest().permitAll()
		.and()
			.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/login")
			.successHandler(myAuthenticationSuccessHandler())
			.usernameParameter("username")
			.passwordParameter("pass")
			.permitAll()
		.and()	
			.logout();
		
	}
	
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Bean
	public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
		return new MyUrlAuthenticationSuccessHandler();
	}
}
