package br.com.thymeleaf.demo.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.thymeleaf.demo.entity.Departamento;

public interface DepartamentoRepository extends CrudRepository<Departamento, Long>{

}
