 package com.api.vendas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.vendas.domain.entity.Cliente;
import com.api.vendas.domain.repository.Clientes;

@SpringBootApplication
@RestController
public class VendasApplication {

	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes) {
		return args -> {
			System.out.println("Salvando clientes");
			clientes.salvar(new Cliente("Maria"));
			clientes.salvar(new Cliente("Jessica"));
			
			List<Cliente> todosClientes = clientes.obterTodos();
			todosClientes.forEach(System.out::println);
			 System.out.println("Atualizando clientes");
           todosClientes.forEach(c -> {
               c.setNome(c.getNome() + " atualizado.");
               clientes.atualizar(c);
           });

           todosClientes = clientes.obterTodos();
          todosClientes.forEach(System.out::println);

          System.out.println("Buscando clientes");
          clientes.buscarPorNome("Cli").forEach(System.out::println);

           System.out.println("deletando clientes");
           clientes.obterTodos().forEach(c -> {
               clientes.deletar(c);
           });

           todosClientes = clientes.obterTodos();
           if(todosClientes.isEmpty()){
               System.out.println("Nenhum cliente encontrado.");
           }else{               todosClientes.forEach(System.out::println);
         }
		};
		
	}
	
	
	@Value("${application.name}")
	private String applicationName;
	
	
	@GetMapping("/hello")
	public String helloWorld() {
		return applicationName;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
