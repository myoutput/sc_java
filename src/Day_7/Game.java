package Day_7;

import java.util.Random;
import java.util.Scanner;

public class Game {
	enum Shape{SPADE,DIAMOND,HEART,CLOVER}; //모양으로 enum 선언
	Shape shape;
	int number;
	
	//카드의 내용을 출력하는 메소드
	void show() {
		//숫자가 1이면 Ace로 출력
		if(number == 1) {
			System.out.println(shape + " "+ "Ace");
		}
		//숫자가 11이면 J로 출력
		else if(number == 11) {
			System.out.println(shape + " "+ "J");
		}
		//숫자가 12이면 Q로 출력
		else if(number == 12) {
			System.out.println(shape + " "+ "Q");
		}
		//숫자가 13이면 K로 출력
		else if(number == 13) {
			System.out.println(shape + " "+ "K");
		}
		//숫자와 모양 출력
		else {
			System.out.println(shape + " "+ number);
		}
	}
	
	//랜덤으로 숫자를 가져오는 메소드
	public static int rand_num() {
		int number[] = new int[52]; //원소가 52개인 배열의 선언과 생성
		boolean swit[] = new boolean[52]; //원소가 52개인 배열의 선언과 생성
		int a, b = 0;
		int cardNumber = 0;
		
		//배열 초기화
		for (int i = 0; i < swit.length; i++) {
			swit[i] = false;
		}
		a = 0;
		
		while(a < 52) {
			b = (int)(Math.random() * 52); //0~51까지 숫자 랜덤 뽑기
			//중복없이 숫자저장
			if(swit[b] == false) {
				swit[b] = true;
				number[a] = b;
				a++;
			}
		}
		//number배열에 있는 수 cardNumber에 저장
		for(int j=0;j<number.length;j++) {
			cardNumber = number[j] % 13 + 1;}
		
		return cardNumber; //cardNumber 반환
	}
	
	//랜덤으로 모양을 가져오는 메소드
	public static Shape rand_shape() {
		return Shape.values()[new Random().nextInt(Shape.values().length)];
	}
	
	//아무것도 입력하지 않았을 경우
	public Game() {
		this(rand_shape(),rand_num()); //둘다 랜덤으로 대입
	}
	
	//둘다 입력했을 경우
	public Game(Shape shape,int number) {
		this.shape = shape; //입력된 모양 대입
		this.number = number; //입력된 숫자 대입
	}
	
	//모양만 입력했을 경우
	public Game(Shape shape) {
		this(shape,rand_num()); //입력된 모양과 랜덤 숫자 대입
	}
	
	//숫자만 입력했을 경우
	public Game(int number) {
		this(rand_shape(),number); //랜덤 모양과 숫자 대입
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//둘다 입력했을 경우
		System.out.print("Input Card Shape and Number : ");
		String type1 = scanner.next(); //사용자에게 모양 받기
		int number1 = scanner.nextInt(); //사용자에게 숫자 받기
		Shape shape1 = Shape.valueOf(type1); //입력된 모양과 일치하는 값 받기
		Game c1 = new Game(shape1,number1); //객체 생성, 모양과 숫자 대입
		c1.show(); //출력 메소드 호출
		
		System.out.print("Input Card Shape Only : ");
		String type2 = scanner.next(); //사용자에게 모양 받기
		Shape shape2 = Shape.valueOf(type2); //입력된 모양과 일치하는 값 받기
		Game c2 = new Game(shape2); //객체 생성, 모양 대입
		c2.show(); //출력 메소드 호출
		
		System.out.print("Input Card Number Only : ");
		int number3 = scanner.nextInt(); //사용자에게 숫자 받기
		Game c3 = new Game(number3); //객체 생성, 숫자 대입
		c3.show(); //출력 메소드 호출
		
		System.out.print("Generate a random Card : ");
		Game c4 = new Game(); //객체 생성
		c4.show(); //출력 메소드 호출
		
		scanner.close(); //스캐너종료
	}

}