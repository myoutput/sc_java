package Day_3;

import java.util.Scanner;

public class word {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String stringArray[] = new String[7]; //단어를 담을 배열 만들기
		int count = 0; //글자수를 셀 변수
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("단어를 입력하시오 (50자 이상이면 A, 이하면 B를 출력합니다.) : ");

		//글자를 7번 받기 반복
		for(int i =0;i<7;i++) {
			stringArray[i] = scanner.next();
		}
		
		//원소를 순차적으로 접근하여 글자수를 count에 저장
		for(String s:stringArray) {
			count += s.length();
		}
		System.out.println("총 글자수 : "+count); //총 글자수 출력
		
		//만약 50자가 넘으면 A 출력
		if(count>50) {
			System.out.println("A");
		}
		else{ //아니라면 B 출력
			System.out.println("B");
		}
			
	}

}
