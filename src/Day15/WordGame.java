package Day15;

import java.util.Random;
import java.util.Scanner;

public class WordGame {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		//과일 6가지로 배열만들기
		String[] fruits = { "orange", "strawberry", "watermelon", "apple", "banana", "blueberry" };

		//배열의 길이만큼 랜덤값을 돌려 index에 대입
		int index = (new Random()).nextInt(fruits.length);

		String solution = fruits[index]; //인덱스 값에 맞는 배열 문자열을 solution에 대입

		 //solution의 길이를 buffer 사이즈로 하는 StringBuffer 생성
		StringBuffer answ = new StringBuffer(solution.length());
		
		//for문을 통해 _ 추가
		for (int i = 0; i < solution.length(); i++) {
			answ.append("_");
		}
		
		while (true) {
			System.out.println("현재의 상태: " + answ); //현재의 상태 출력
			
			//answ의 문자열과 solution과 같으면 실행을 중지
			if (solution.equals(answ.toString())) {
				break;
			}
			
			System.out.print("글자를 추측하세요: ");
			
			//문자 받기
			char c = sc.next().charAt(0);
			
			//for문과 setCharAt 메소드를 통해 맞힌 _를 받은 문자로 바꾸기
			for (int i = 0; i < solution.length(); i++) {
				if (c == solution.charAt(i)) {
					answ.setCharAt(i, c);
				}
			}

		}
		sc.close(); //스캐너 종료
	}
	
}
