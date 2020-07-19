package br.com.projuris.atividade2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projuris.FindCharachter;
import br.com.projuris.MyFindChar;

@SpringBootApplication
@RestController
public class Atividade2Application {

	@GetMapping("/")
	public String getResults() {

		FindCharachter findCharachter = new MyFindChar();
		String word1 = "stress";
		char result1 = findCharachter.findChar(word1);

		String word2 = "reembolsar";
		char result2 = findCharachter.findChar(word2);

		return ".<br>stress -> Result " + result1 + "<br>" + "reembolsar -> Result " + result2;
	}

	public static void main(String[] args) {
		SpringApplication.run(Atividade2Application.class, args);
	}

}
