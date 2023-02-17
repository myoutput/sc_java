package Day_1;

public class temperature {
	//변환하는 메소드
	public static double tem(double F, int C) {
		F = C * 1.8 + 32; 
		return F;
	}

	//main() 메소드
	public static void main(String[] args) {
	
		int F=0; 
		int C=28;
		double Temperature;
		Temperature = tem(F,C); //tem() 메소드 호출
		System.out.println(C+"C -> "+Temperature+"F"); //문자열 및 값 호출

	}

}
