package br.com.rodrigo.desafio_todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;


@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "ToDO List",
                description = "API desenvolvida como solução para o desafio de código no Bootcamp da DIO e GFT",
                version = "1.0"               
                ),
        servers = @Server(
                url = "/",
                description = "Descrição do Server"
                ))
public class DesafioTodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioTodolistApplication.class, args);
	}

}
