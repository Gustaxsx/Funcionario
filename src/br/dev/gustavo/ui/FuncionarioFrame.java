package br.dev.gustavo.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.dev.gustavo.dao.FuncionarioDAO;
import br.dev.gustavo.tarefas.model.Funcionario;
import br.dev.gustavo.utils.Utils;

public class FuncionarioFrame {

	private JLabel labelMatricula;
	private JLabel labelNome;
	private JLabel labelCargo;
	private JLabel labelSetor;
	private JLabel labelSalario;
	private JTextField txtMatricula;
	private JTextField txtNome;
	private JTextField txtCargo;
	private JTextField txtSetor;
	private JTextField txtSalario;
	private JButton btnSalvar;
	private JButton btnSair;

	public FuncionarioFrame() {

		criarTela();
	}

	private void criarTela() {
		JFrame telaFuncionario = new JFrame("Cadastro Funcionario");
		telaFuncionario.setSize(500, 500);
		telaFuncionario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaFuncionario.setLayout(null);
		telaFuncionario.setResizable(false);
		telaFuncionario.setLocationRelativeTo(null);

		Container painel = telaFuncionario.getContentPane();

		labelMatricula = new JLabel("Matricula:");
		labelMatricula.setBounds(10, 20, 150, 30);
		txtMatricula = new JTextField();
		txtMatricula.setBounds(10, 50, 150, 30);
		txtMatricula.setEnabled(false);
		txtMatricula.setText(Utils.gerarUUID8());

		labelNome = new JLabel("Nome");
		labelNome.setBounds(10, 85, 150, 30);
		txtNome = new JTextField();
		txtNome.setBounds(10, 115, 300, 30);

		labelCargo = new JLabel("Cargo");
		labelCargo.setBounds(10, 150, 150, 30);
		txtCargo = new JTextField();
		txtCargo.setBounds(10, 180, 250, 30);

		labelSetor = new JLabel("Setor");
		labelSetor.setBounds(10, 215, 150, 30);
		txtSetor = new JTextField();
		txtSetor.setBounds(10, 245, 200, 30);

		labelSalario = new JLabel("Salario");
		labelSalario.setBounds(10, 280, 150, 30);
		txtSalario = new JTextField();
		txtSalario.setBounds(10, 310, 150, 30);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 380, 200, 40);

		btnSair = new JButton("Sair");
		btnSair.setBounds(220, 380, 120, 40);

		painel.add(labelMatricula);
		painel.add(txtMatricula);
		painel.add(labelNome);
		painel.add(txtNome);
		painel.add(labelCargo);
		painel.add(txtCargo);
		painel.add(labelSetor);
		painel.add(txtSetor);
		painel.add(labelSalario);
		painel.add(txtSalario);
		painel.add(btnSalvar);
		painel.add(btnSair);

		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Funcionario f = new Funcionario(txtNome.getText());
				f.setMatricula(txtMatricula.getText());
				f.setCargo(txtCargo.getText());
				f.setSetor(txtSetor.getText());
				double salario = Double.parseDouble(txtSalario.getText());
				f.setSalario(salario);

				FuncionarioDAO dao = new FuncionarioDAO(f);
				boolean sucesso = dao.gravar();

				if (sucesso) {
					JOptionPane.showMessageDialog(telaFuncionario, "Funcionario gravado com sucesso!!");
					limparFormulario();
				} else {
					JOptionPane.showMessageDialog(telaFuncionario,
							"Ocorreu um erro na gravacao. \nTente novamente.\nSe o problema persistir, entre em contato com o supprte.");
				}

			}
		});

		btnSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(telaFuncionario, "Sair do sistema?", "Atencao",
						JOptionPane.YES_NO_OPTION);

				if (resposta == 0) {

					System.exit(JFrame.EXIT_ON_CLOSE);
				}
			}
		});

		telaFuncionario.setVisible(true);
	}

	private void limparFormulario() {

		txtMatricula.setText(Utils.gerarUUID8());
		txtNome.setText(null);
		txtCargo.setText(null);
		txtSetor.setText(null);
		txtSalario.setText(null);
		txtNome.requestFocus();

	}

}
