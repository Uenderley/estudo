package br.com.thymeleaf.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.thymeleaf.demo.entity.Endereco;
import br.com.thymeleaf.demo.repository.EnderecoRepository;

@Service
@Transactional
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public void salvar(Endereco endereco) {
		enderecoRepository.save(endereco);
	}
	
	public void editar(Endereco endereco) {
		enderecoRepository.save(endereco);
	}
	
	public Optional<Endereco> findById(long id) {
		return enderecoRepository.findById(id);
	}
	
	public Iterable<Endereco> findAll() {
		return enderecoRepository.findAll();
	}
}
