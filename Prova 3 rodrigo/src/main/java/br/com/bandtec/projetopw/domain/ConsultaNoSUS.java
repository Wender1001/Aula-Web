package br.com.bandtec.projetopw.domain;

import br.com.bandtec.projetopw.repository.TodosCidadaos;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="consulta")
public class ConsultaNoSUS {

//	 private TodosCidadaos todosCidadaos;


	@Id
	@GeneratedValue
	private Long id;

	@JsonProperty
	private LocalDate data;

	@JsonProperty
	private String especialidade;


	@ManyToOne
	@JoinColumn(name = "cidadao_id")
	private Cidadao cidadao;
	
	protected ConsultaNoSUS() {}
	
	public ConsultaNoSUS(LocalDate data, String especialidade) {
		this.data = data;
		this.especialidade = especialidade;

	}

	public ConsultaNoSUS(ConsultaNoSUS consulta) {
	}


	public void setCidadao(Cidadao cidadao) {
		this.cidadao = cidadao;
	}

	public Cidadao getCidadao() {
		return cidadao;
	}

//	public Long getId() {
//		return id;
//	}








	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cidadao == null) ? 0 : cidadao.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((especialidade == null) ? 0 : especialidade.hashCode());
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
		ConsultaNoSUS other = (ConsultaNoSUS) obj;
		if (cidadao == null) {
			if (other.cidadao != null)
				return false;
		} else if (!cidadao.equals(other.cidadao))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (especialidade == null) {
			if (other.especialidade != null)
				return false;
		} else if (!especialidade.equals(other.especialidade))
			return false;
		return true;
	}
}
