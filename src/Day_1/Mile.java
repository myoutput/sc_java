package Day_1;

public class Mile {
	//변환하는 메소드
	public static double change(double KmperMile, int mile) {
		return KmperMile*mile; // 반환값 리턴
	}

	//main() 메소드
	public static void main(String[] args) {
		final double KM_PER_MILE = 1.69433; //상수 정의
		double conversion;
		int mile = 95;
		conversion = change(KM_PER_MILE,mile); //change() 메소드 호출
		System.out.println(mile+"mile -> "+conversion+" Km"); //문자열 및 값 화면 출력

	}

}
