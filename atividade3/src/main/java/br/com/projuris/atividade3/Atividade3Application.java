package br.com.projuris.atividade3;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projuris.Calculo;
import br.com.projuris.Funcionario;
import br.com.projuris.MyCalculo;

@SpringBootApplication
@RestController
public class Atividade3Application {

	@GetMapping("/")
	public String getResults() {

		List<Funcionario> listaFuncionario = Arrays.asList(
				new Funcionario("Assistente", "Administrativo", new BigDecimal(1000.0)),
				new Funcionario("Gerente", "Administrativo", new BigDecimal(7000.70)),
				new Funcionario("Diretor", "Administrativo", new BigDecimal(10000.45)),
				new Funcionario("Assistente", "Financeiro", new BigDecimal(1300.9)),
				new Funcionario("Gerente", "Financeiro", new BigDecimal(7500)),
				new Funcionario("Diretor", "Financeiro", new BigDecimal(11000.0)),
				new Funcionario("Estagiário", "Jurídico", new BigDecimal(700.4)),
				new Funcionario("Assistente", "Jurídico", new BigDecimal(1800.90)),
				new Funcionario("Gerente", "Jurídico", new BigDecimal(9500.50)),
				new Funcionario("Diretor", "Jurídico", new BigDecimal(13000.0)));

		StringBuilder result = new StringBuilder(".<br>");
		result.append("Cargo X Custo<br>");

		Calculo calculo = new MyCalculo();
		calculo.custoPorCargo(listaFuncionario)
				.forEach(el -> result.append("Cargo: " + el.getCargo() + ", Custo: " + el.getCusto() + "<br>"));

		result.append("<br><br> Departamento X Custo<br>");
		calculo.custoPorDepartamento(listaFuncionario).forEach(
				el -> result.append("Departamento: " + el.getDepartamento() + ", Custo: " + el.getCusto() + "<br>"));

		return result.toString();
	}

	public static void main(String[] args) {
		SpringApplication.run(Atividade3Application.class, args);
	}

}
