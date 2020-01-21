package br.com.thymeleaf.demo.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.thymeleaf.demo.entity.Endereco;

public interface EnderecoRepository extends CrudRepository<Endereco, Long>{

}
