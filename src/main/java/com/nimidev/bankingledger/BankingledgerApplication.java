package com.nimidev.bankingledger;

import com.nimidev.bankingledger.domain.Bank;
import com.nimidev.bankingledger.repository.BankRepository;
import com.nimidev.bankingledger.service.audit.AuditorAwareImpl;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDateTime;

@SpringBootApplication
@EntityScan
@EnableJpaRepositories
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class BankingledgerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingledgerApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditorAwareImpl();
	}

//	@Bean
//	public CommandLineRunner createBankMasterData(BankRepository bankRepository) {
//		return args -> {
//			if (bankRepository.count() == 0) {
//				log.info("Generating demo data...");
//				var generator = new ExampleDataGenerator<>(Bank.class, LocalDateTime.now());
//			}
//		};
//	}
}
