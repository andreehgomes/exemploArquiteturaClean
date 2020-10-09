package br.com.systemmcr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CleanApplication {

	public static void main(String[] args) {
		
		BCryptPasswordEncoder pass = new BCryptPasswordEncoder();
		System.out.println("senha " + pass.encode("adm123"));
		
		
	}

}
