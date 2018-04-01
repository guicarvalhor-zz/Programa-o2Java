package Atividade3;

import javax.swing.JOptionPane;

public class Salario {

	public static void main(String[] args) {

		Double calculoINSS = 0.0;
		Double calculoIRPF = 0.0;
		Double resultado = 0.0;
		Double liquido = 0.0;
		Double renda = 0.0;

		JOptionPane.showMessageDialog(null, "Sistema de Calculo de Salario Liquido - Padrão 2018");

		String r = JOptionPane.showInputDialog("Digite sua Renda Mensal, sem Virgulas ou Pontos: (Digite 0 para sair.)");
		double rendaFixa = Double.parseDouble(r);

		if (r.equals("0")) {
			JOptionPane.showMessageDialog(null, "Programa Encerrado");
		} else {
			String d = JOptionPane.showInputDialog("Digite o numero de dependentes:");
			double dependentes = Double.parseDouble(d);

			renda = rendaFixa;

			// calculando o INSS
			if (renda <= 1693.72) {
				calculoINSS = renda * 0.08;
			} else if (renda >= 1693.72 && renda <= 2822.90) {
				calculoINSS = renda * 0.09;
			} else if (renda >= 2822.90 && renda <= 5645.80) {
				calculoINSS = renda * 0.11;
			} else {
				calculoINSS = renda * 621.04;
			}

			renda = renda - calculoINSS;

			// Calculando o imposto IPRF
			calculoIRPF = (renda - (dependentes * 189.59));

			if (calculoIRPF <= 1903.98) {
				resultado = 0.0;
			} else if (calculoIRPF >= 1903.99 && calculoIRPF <= 2826.65) {
				resultado = ((calculoIRPF * 0.075) - (142.80));
			} else if (calculoIRPF >= 2826.66 && calculoIRPF <= 3751.05) {
				resultado = ((calculoIRPF * 0.15) - (354.80));
			} else if (calculoIRPF >= 3751.06 && calculoIRPF <= 4664.68) {
				resultado = ((calculoIRPF * 0.225) - (636.13));
			} else if (calculoIRPF >= 4664.68) {
				resultado = ((calculoIRPF * 0.275) - (869.36));
			}

			// Calculo de Salario liquido
			liquido = rendaFixa - calculoINSS - resultado;

			// exibindo os salarios e impostos

			JOptionPane.showMessageDialog(null,
					"\n O Imposto INSS a ser aplicado e de:" + calculoINSS
							+ "\n O Imposto IRPF a ser aplicado com a deducao de dependentes e de:" + resultado
							+ "\n O Salario liquido a ser recebido e de:" + liquido);

		}

	}

}
