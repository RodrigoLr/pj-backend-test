package br.com.projuris.atividade1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projuris.FindArray;
import br.com.projuris.MyFindArray;

@SpringBootApplication
@RestController
public class Atividade1Application {

	@GetMapping("/")
	public String getResults() {

		FindArray findArray = new MyFindArray();
		int[] array1 = { 4, 9, 3, 7, 8 };
		int[] subArray1 = { 3, 7 };
		int position1 = findArray.findArray(array1, subArray1);

		int[] array2 = { 1, 3, 5 };
		int[] subArray2 = { 1 };
		int position2 = findArray.findArray(array2, subArray2);

		int[] array3 = { 7, 8, 9 };
		int[] subArray3 = { 8, 9, 10 };
		int position3 = findArray.findArray(array3, subArray3);

		int[] array4 = { 4, 9, 3, 7, 8, 3, 7, 1 };
		int[] subArray4 = { 3, 7 };
		int position4 = findArray.findArray(array4, subArray4);

		return ".<br>[4,9,3,7,8] and [3,7] -> Position " + position1 + "<br>" + "[1,3,5] and [1] -> Position "
				+ position2 + "<br>" + "[7,8,9] and [8,9,10] -> Position " + position3 + "<br>"
				+ "[4,9,3,7,8,3,7,1] and [3,7] -> Position " + position4 + "<br>";
	}

	public static void main(String[] args) {
		SpringApplication.run(Atividade1Application.class, args);
	}

}
