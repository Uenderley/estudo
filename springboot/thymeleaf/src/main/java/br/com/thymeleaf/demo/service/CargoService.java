package br.com.thymeleaf.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.thymeleaf.demo.entity.Cargo;
import br.com.thymeleaf.demo.repository.CargoRepository;

@Service
@Transactional
public class CargoService {
	
	@Autowired
	private CargoRepository cargoRepository;
	
	public void salvar(Cargo cargo) {
		cargoRepository.save(cargo);
	}
	
	public void editar(Cargo cargo) {
		cargoRepository.save(cargo);
	}
	
	public Optional<Cargo> findById(long id) {
		return cargoRepository.findById(id);
	}
	
	public Iterable<Cargo> findAll() {
		return cargoRepository.findAll();
	}
	
}
