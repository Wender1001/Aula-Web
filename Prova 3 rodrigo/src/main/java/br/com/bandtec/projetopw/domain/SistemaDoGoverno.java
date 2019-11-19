package br.com.bandtec.projetopw.domain;

import java.util.List;

import org.springframework.web.client.RestTemplate;

public class SistemaDoGoverno {

	private final RestTemplate restTemplate;
	
	public SistemaDoGoverno() {
		this.restTemplate = new RestTemplate();
	}
	
	public List<Municipio> municipiosDoEstado(String estado){
		return null;
	}
}
