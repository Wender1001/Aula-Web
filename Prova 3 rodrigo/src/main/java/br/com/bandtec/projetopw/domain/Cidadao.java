package br.com.bandtec.projetopw.domain;

import br.com.bandtec.projetopw.repository.TodosCidadaos;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="cidadaos")
public class Cidadao {

//	private TodosCidadaos todosCidadaos;

	@Id
	@GeneratedValue
	private Long id;

	@JsonProperty
	private String nome;
	
	@Embedded
	@JsonProperty
	private CPF cpf;

	@JsonProperty
	private Integer idade;


	@OneToMany(mappedBy = "cidadao", cascade = CascadeType.ALL)
	private List<ConsultaNoSUS> consultas;

	//ArrayList<ConsultaNoSUS> consulte = new ArrayList<ConsultaNoSUS>();


	protected Cidadao() {}
	
	public Cidadao(String nome, CPF cpf, int idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.consultas = new ArrayList<>();
	}

	public void  inserir(ConsultaNoSUS consulta) {
		this.consultas.add(consulta);
			consulta.setCidadao(this);
	}


	public Long getId() {
		return id;
	}

	public boolean contem(ConsultaNoSUS consulta) {
		return consultas.contains(consulta);
	}

	public int lerIdade() {
		return idade;
	}

	public List<ConsultaNoSUS> getConsultas( ) {
		return consultas;
	}

//	public Cidadao getCidadaoCpf(){return todosCidadaos.comCpf(cpf);}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidadao other = (Cidadao) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
}
