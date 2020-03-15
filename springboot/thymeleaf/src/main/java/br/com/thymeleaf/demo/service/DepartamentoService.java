package br.com.thymeleaf.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.thymeleaf.demo.entity.Departamento;
import br.com.thymeleaf.demo.repository.DepartamentoRepository;

@Service
@Transactional
public class DepartamentoService {
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	public void salvar(Departamento departamento) {
		departamentoRepository.save(departamento);
	}
	
	public void editar(Departamento departamento) {
		departamentoRepository.save(departamento);
	}
	
	public Optional<Departamento> findById(long id) {
		return departamentoRepository.findById(id);
	}
	
	public Iterable<Departamento> findAll() {
		return departamentoRepository.findAll();
	}

	public boolean isTemCargo(Long id) {
		if(findById(id).get().getCargos().isEmpty()) {
			return false;
		}
		return true;
	}

	public void excluir(Long id) {
		departamentoRepository.deleteById(id);
	}
}
