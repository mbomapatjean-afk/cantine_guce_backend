package com.guce.cantine;

import com.guce.cantine.entity.Commande;
import com.guce.cantine.entity.Menu;
import com.guce.cantine.entity.User;
import com.guce.cantine.repository.CommandeRepository;
import com.guce.cantine.repository.MenuRepository;
import com.guce.cantine.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@SpringBootApplication
public class CantineApplication {

	public static void main(String[] args) {
		SpringApplication.run(CantineApplication.class, args);
	}

	@Configuration
	public static class SecurityConfig {

		@Bean
		public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
			http
					.csrf(AbstractHttpConfigurer::disable) // nouvelle syntaxe pour désactiver CSRF
					.authorizeHttpRequests(auth -> auth
							.anyRequest().permitAll() // tout est accessible pour tests
					);

			return http.build();
		}
	}

/*
	@Component
	public class TestDatabaseRunner implements CommandLineRunner {

		@Autowired
		private CommandeRepository commandeRepository;

		@Autowired
		private UserRepository userRepository;

		@Autowired
		private MenuRepository menuRepository;

		@Override
		public void run(String... args) throws Exception {
			// Récupération d'un user existant (ou créer si nécessaire)
			User user = userRepository.findById(1L).orElseGet(() -> {
				User u = new User();
				u.setNom("Test User");
				return userRepository.save(u);
			});

			// Récupération d'un menu existant (ou créer si nécessaire)
			Menu menu = menuRepository.findById(1L).orElseGet(() -> {
				Menu m = new Menu();
				m.setNom("Menu Test");
				return menuRepository.save(m);
			});

			// Création d'une commande test
			Commande cmd = new Commande();
			cmd.setUser(user);
			cmd.setMenu(menu);
			cmd.setDateChoix(LocalDate.now());
			cmd.setQrCode("TEST-QRCODE-123");

			commandeRepository.save(cmd);

			// Lecture de toutes les commandes
			System.out.println("Toutes les commandes dans la DB :");
			commandeRepository.findAll().forEach(c -> {
				System.out.println(
						c.getId() + " \n " +
								c.getUser().getNom() + " \n " +
								c.getMenu().getNom() + " \n " +
								c.getDateChoix() + " \n " +
								c.getQrCode()
				);
			});
		}
	}
 */
}
