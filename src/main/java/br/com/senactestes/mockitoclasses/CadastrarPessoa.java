 package br.com.senactestes.mockitoclasses;

import java.time.LocalDate;

public class CadastrarPessoa {

	private ApiDosCorreios apiDosCorreios;
	
	public CadastrarPessoa(final ApiDosCorreios apiDosCorreios) {
		this.apiDosCorreios = apiDosCorreios;
	}
	
	public Pessoa cadastrarPessoa(String nome, String documento, LocalDate nascimento, int cep) {
		Pessoa pessoa = new Pessoa(nome, documento, nascimento);
		DadosLocalizacao dadosLocalizacao = apiDosCorreios.buscaDadosCep(cep);
		pessoa.adicionaDadosEndereco(dadosLocalizacao);
		return pessoa;
	}
}
