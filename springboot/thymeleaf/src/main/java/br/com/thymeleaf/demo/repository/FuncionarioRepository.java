package br.com.thymeleaf.demo.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.thymeleaf.demo.entity.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long>{

}