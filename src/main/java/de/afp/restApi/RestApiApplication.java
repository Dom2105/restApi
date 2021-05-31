package de.afp.restApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
 * @SpringBootApplication wird der Hauptklasse der Anwendung zugewiesen, die im
 * Top-Level-Paket liegen muss. Spring Boot wird dadurch alle Unterordner
 * scannen.
 * 
 * @SpringBootApplication kombiniert @Configuration, @EnableAutoConfiguration
 * und @ComponentScan.
 */
public class RestApiApplication {

	public static void name(String[] ka, String... ka2) {
		System.out.println(ka);
		System.out.println(ka2);
	}

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);

		String name = "Dom";

		String[] namen = { "fanar", "Dominic", "Alex" };

		/* String[] nachnamen = new String[4]; */

		name(namen, name);

	}

}
