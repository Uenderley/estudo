package br.com.thymeleaf.demo.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.thymeleaf.demo.entity.Cargo;

public interface CargoRepository extends CrudRepository<Cargo, Long>{

}
