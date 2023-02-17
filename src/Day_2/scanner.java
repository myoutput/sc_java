package Day_2;

import java.util.Scanner;

public class scanner {
	
	public static double tem(double F, int C) {
		F = C * 1.8 + 32; 
		return F;
	}
	
	public static double change(double KmperMile, int mile) {
		return KmperMile*mile; // 반환값 리턴
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int F=0; 
		System.out.println("변환할 섭씨 온도를 입력하세요 : ");
		int C=scanner.nextInt();
		double Temperature;
		Temperature = tem(F,C); //tem() 메소드 호출
		System.out.println(C+"C -> "+Temperature+"F"); //문자열 및 값 호출
		
		final double KM_PER_MILE = 1.69433; //상수 정의
		double conversion;
		System.out.println("변환할 mile를 입력하세요 : ");
		int mile = scanner.nextInt();
		conversion = change(KM_PER_MILE,mile); //change() 메소드 호출
		System.out.println(mile+"mile -> "+conversion+" Km"); //문자열 및 값 화면 출력

	}

}
