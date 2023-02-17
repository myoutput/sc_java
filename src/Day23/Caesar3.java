package Day23;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Day21.Caesar;

public class Caesar3 {
	
	//암호화
	public static String encode(String enc, int n) {
		n = n % 26 + 26;
		StringBuilder en = new StringBuilder(); //StringBuilder 객체 선언
		//문자열을 char 형태로 바꿔 문자 끝까지 for문을 돌림
		for (char i : enc.toCharArray()) {
			if (Character.isLetter(i)) { //만일 i가 문자라면 if문 실행
				//만일 문자가 대문자라면
				if (Character.isUpperCase(i)) {
					//원하는 만큼 shift해주고 소문자로 변환(여기서는 3칸)
					en.append((char) Character.toLowerCase(('A' + (i - 'A' + n) % 26)));	
				} 
				//아니라면
				else {
					//원하는 만큼 shift해주고 대문자로 변환(여기서는 3칸)
					en.append((char) Character.toUpperCase(('a' + (i - 'a' + n) % 26)));
				}
			}
			
			//문자가 아니라면
			else {
				en.append(i); //이어 붙이기
			}
		}
		return en.toString(); //문자열로 리턴
	}

	//복호화
	public static String decode(String enc, int n) {
		return encode(enc, 26 - n);
	}
	
	public static void main(String[] args) throws IOException {
		
		try {
			FileReader fr = new FileReader("ciphertext.txt"); //ciphertext 텍스트파일 읽어들이기
			BufferedReader br = new BufferedReader(fr); //버퍼에 입력받기
			FileWriter fw1 = new FileWriter("enc.txt"); //enc라는 텍스트파일 생성
			
			String line = "";
			
			for(int i =1;(line = br.readLine())!=null;i++) {
				System.out.println(Caesar.encode(line, 11));
				fw1.write(Caesar3.encode(line, 11));
			}

			fw1.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		

	}
}
