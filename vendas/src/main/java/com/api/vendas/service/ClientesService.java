package com.api.vendas.service;

import org.springframework.stereotype.Service;

import com.api.vendas.model.Cliente;
import com.api.vendas.repository.ClientesRepository;

@Service
public class ClientesService {

	private ClientesRepository repository;

	public ClientesService(ClientesRepository repository) {
		this.repository = repository;
	}
	
	
	public void salvarCliente(Cliente cliente) {
		validarCliente(cliente);
		this.repository.persistir(cliente);
	}
	
	public void validarCliente(Cliente cliente) {
		
		
	}
	
	
	
	
}
