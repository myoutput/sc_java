package Day21;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Caesar2 {

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("input.txt");
		BufferedReader br = new BufferedReader(fr);
		String plaintext = br.readLine();
		
	}
}

//('A' + (i - 'A' + 3) % 26));