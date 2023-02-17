package Day_2;

import java.util.Scanner;

public class ScannerHW {
	//변환하는 메소드 (화씨 -> 섭씨)
	public static double tem_1(double F, double C) {
		C = 5.0/9.0 * (F-32.0);
		return C;
	}
	
	//변환하는 메소드 (섭씨 -> 화씨)
	public static double tem_2(double F, double C) {
		F = (9.0/5.0*C) + 32.0; 
		return F;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("이름을 입력하시오 : ");
		String name=scanner.next();  //이름 입력 받기

		System.out.println("학번을 입력하시오 : ");
		int number=scanner.nextInt(); //학번 입력 받기

		System.out.println("학년을 입력하시오 : ");
		int grade=scanner.nextInt(); //학년 입력 받기

		System.out.println("전공을 입력하시오 : ");
		String major=scanner.next(); //전공 입력 받기
		System.out.println("이름 : "+name+", 학번 : "+number+", 학년 : "+grade+", 전공 : "+major); //모두 출력
		
		System.out.println("==========================");
		System.out.println("1. 화씨 -> 섭씨\n2. 섭씨 -> 화씨");
		System.out.println("==========================");
		
		int num = scanner.nextInt(); //번호 입력받기
		//1을 입력했을 경우(화씨 -> 섭씨)
		if(num ==1) {
			int C=0; 
			System.out.println("변환할 화씨 온도를 입력하세요 : ");
			int F=scanner.nextInt(); //화씨 온도 입력받기
			double Temperature;
			Temperature = tem_1(F,C); //tem_1() 메소드 호출
			System.out.println("섭씨 온도는 "+Temperature); //문자열 및 값 호출
		}
		
		//2를 입력했을 경우(섭씨 -> 화씨)
		else if(num ==2) {
			int F=0; 
			System.out.println("변환할 섭씨 온도를 입력하세요 : ");
			int C=scanner.nextInt(); //섭씨 온도 입력받기
			double Temperature;
			Temperature = tem_2(F,C); //tem_2() 메소드 호출
			System.out.println("화씨 온도는 "+Temperature); //문자열 및 값 호출
			
		}		
		scanner.close(); //스캐너 사용 종료
	}

}
