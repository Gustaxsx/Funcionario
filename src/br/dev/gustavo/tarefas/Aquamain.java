package br.dev.gustavo.tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

import br.dev.gustavo.dao.FuncionarioDAO;
import br.dev.gustavo.tarefas.model.Funcionario;
import br.dev.gustavo.tarefas.model.Status;
import br.dev.gustavo.tarefas.model.Tarefa;
import br.dev.gustavo.ui.FuncionarioFrame;
import br.dev.gustavo.ui.FuncionarioListaFrame;
import br.dev.gustavo.utils.Utils;

public class Aquamain {

	public static void main(String[] args) {
		
		FuncionarioDAO dao = new FuncionarioDAO(null);
		dao.getFuncionarios();
		
	//	new FuncionarioListaFrame();
	//	new FuncionarioFrame();

		//Funcionario funcionario = new Funcionario("Robson", "Programador");
		//funcionario.setSetor("Tecnologia da informacao");
		//funcionario.setSalario(6987.98);
		
		//FuncionarioDAO dao = new FuncionarioDAO(funcionario);
		//dao.gravar();
	}

	private static void testarLeituraEscritaArquivo() {
		String caminho = "/Users/25133416/projetoTarefasDS1MA/tarefas";

		FileReader fr = null;
		BufferedReader br = null;

		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fr = new FileReader(caminho);
			br = new BufferedReader(fr);

			fw = new FileWriter(caminho, true);
			bw = new BufferedWriter(fw);

			bw.append("mandela\n");
			bw.flush();

			String linha = br.readLine();

			while (linha != null) {
				System.out.println(linha);
				linha = br.readLine();

			}

		} catch (FileNotFoundException erro) {
			System.out.println("Arquivo nao encontrado");
		} catch (IOException erro) {
			System.out.println("Houve um erro de leitura");
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
	}

}
