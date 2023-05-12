package br.com.senactestes.mockitoclasses;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTeste {
	
	//1. CRIAÇÃO DE CENÁRIO
	//1.1. Instrumentação do descritor do mock
	//1.1.1. Inserção do descritor mock
	
	//descreve o objeto a ser usado no teste 
	@Mock
	private ApiDosCorreios apiDosCorreios;
	
	//1.1.2. Injeção de dependência da regra de negócio a ser testado
	//injetando uma regra de negócios
	@InjectMocks
	private CadastrarPessoa cadastrarPessoa;
	
	
	
	
	@Test
	void cadastrarPessoa() {
		//1.2. Inserção dos dados a serem mockados
		//Dados fictícios do objeto que eu estou mockando.
		DadosLocalizacao dadosLocalizaco = new DadosLocalizacao("SP", "Atibaia", "Rua Antoni Massoni", "Casa", "Nova floresta");
		
		//1.3. Execução do Mock
		Mockito.when(apiDosCorreios.buscaDadosCep(anyInt())).thenReturn(dadosLocalizaco);
		
		Pessoa miguel = cadastrarPessoa.cadastrarPessoa("Miguel", "123456", LocalDate.of(1995, 9, 18), 22775045);
		
		
		//2. EXECUÇÃO E ANÁLISE (ASSERTS) DO TESTE
		DadosLocalizacao enderecoMiguel = miguel.getEndereco();
		assertEquals(dadosLocalizaco.getBairro(), enderecoMiguel.getBairro());
		assertEquals(dadosLocalizaco.getCidade(), enderecoMiguel.getCidade());		
		assertEquals(dadosLocalizaco.getUf(), enderecoMiguel.getUf());
	}
	
}
