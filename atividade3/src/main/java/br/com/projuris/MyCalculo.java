package br.com.projuris;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class MyCalculo implements Calculo {

	@Override
	public List<CustoCargo> custoPorCargo(List<Funcionario> funcionarios) {
		List<CustoCargo> custosPorCargo = funcionarios.stream()
				.collect(Collectors.groupingBy(Funcionario::getCargo,
						Collectors.reducing(BigDecimal.ZERO, Funcionario::getSalario, BigDecimal::add)))
				.entrySet().stream().map(e2 -> new CustoCargo(e2.getKey(), e2.getValue())).collect(Collectors.toList());
		return custosPorCargo;
	}

	@Override
	public List<CustoDepartamento> custoPorDepartamento(List<Funcionario> funcionarios) {
		List<CustoDepartamento> custosPorDepartamento = funcionarios.stream()
				.collect(Collectors.groupingBy(Funcionario::getDepartamento,
						Collectors.reducing(BigDecimal.ZERO, Funcionario::getSalario, BigDecimal::add)))
				.entrySet().stream().map(e2 -> new CustoDepartamento(e2.getKey(), e2.getValue()))
				.collect(Collectors.toList());
		return custosPorDepartamento;
	}

}
