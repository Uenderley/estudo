package br.com.thymeleaf.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "cargo", schema = "public")
public class Cargo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "public.cargo_id_seq")
    @SequenceGenerator(name = "public.cargo_id_seq", sequenceName = "public.cargo_id_seq", allocationSize = 1)
    private long id;
	
	@Column(nullable = false, unique = true, length = 60)
	private String nome;
	
	@ManyToOne
    @JoinColumn(name = "id_departamento", nullable = false)
	private Departamento departamento;
	
	@OneToMany(mappedBy = "cargo")
	private List<Funcionario> funcionarios;

}
