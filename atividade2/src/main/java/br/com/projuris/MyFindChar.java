package br.com.projuris;

public class MyFindChar implements FindCharachter {

	@Override
	public char findChar(String word) {
		for (Character character : word.toCharArray()) {
			if (word.indexOf(character) == word.lastIndexOf(character)) {
				return character;
			}
		}
		return ' ';
	}

}
