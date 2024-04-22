package br.com.fiap.techchallenger4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LogisticaEntregaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogisticaEntregaApplication.class, args);
	}

}
