package za.co.team02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import za.co.team02.model.SiteUser;
import za.co.team02.repository.UserRepository;

import java.util.Arrays;

@SpringBootApplication
public class Team02Application
{

	public static void main(String[] args)
	{
		ApplicationContext context = SpringApplication.run(Team02Application.class, args);
//		UserRepository mobileRepository = context.getBean(UserRepository.class);
//		EventRepository appRepository = context.getBean(EventRepository.class);
	}

	public Team02Application(UserRepository userRepository) {
		SiteUser admin = SiteUser.builder()
				.email("hloni@gmail.com")
				.firstName("Hloni")
				.lastName("Moloi")
				.username("@hloni")
				.password("71cf426fda18e7d884cff448e6d7920f9219c79ea85a6cac385a2b46c928d8ae")
				.role("admin")
				.address("Ameshoff JHB").build();
		userRepository.save(admin);

		SiteUser user = SiteUser.builder()
				.email("bonga@gmail.com")
				.firstName("Bonga")
				.lastName("Gougota")
				.username("@Bongag")
				.password("d5c40e418539a91860b5bb9ae07f0d51552cfba7b1a5ca37ff8ec8f836f7aca7")
				.role("user")
				.address("Ameshoff JHB").build();
		userRepository.save(user);

		SiteUser user2 = SiteUser.builder()
				.email("nokuthula@gmail.com")
				.firstName("Nokuthula")
				.lastName("Mahlangu")
				.username("nokuthula@gmail.com")
				.password("d5c40e418539a91860b5bb9ae07f0d51552cfba7b1a5ca37ff8ec8f836f7aca7")
				.role("user")
				.address("Ameshoff JHB").build();
		userRepository.save(user2);
	}

	@Bean
	public CorsFilter corsFilter()
	{
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
}
