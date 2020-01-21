package br.com.thymeleaf.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.thymeleaf.demo.entity.Funcionario;
import br.com.thymeleaf.demo.repository.FuncionarioRepository;

@Service
@Transactional
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public void salvar(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
	}
	
	public void editar(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
	}
	
	public Optional<Funcionario> findById(long id) {
		return funcionarioRepository.findById(id);
	}
	
	public Iterable<Funcionario> findAll() {
		return funcionarioRepository.findAll();
	}
}