package it.unisalento.ingsoftware.ciao_mondo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CiaoMondoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CiaoMondoApplication.class, args);
		Cittadino cittadino = context.getBean(Cittadino.class);
		cittadino.setNome("Luca");
		cittadino.setCognome("Mainetti");
		cittadino.ciaoCittadino("Lecce", "Novoli");
	}
}
