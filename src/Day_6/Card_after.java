package Day_6;

import java.util.Scanner;

//카드 클래스
public class Card_after {
	int number; //카드 숫자 필드
	String shape; //카드 모양 필드
	int n1, n2;
	
	public Card_after() {} //카드의 생성자
	
	//카드의 내용(숫자와 모양)을 출력하는 메소드
	public void show() {
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
	
	// card1 객체와 card2 객체의 크기를 비교하는 메소드
	public void compare(Card_after card1,Card_after card2) {
		//카드 모양의 우선순위를 매기기 위해서 우선 순위대로 큰 수 지정
		if(card1.shape.equals("SPADE")) n1=3; 
		else if(card1.shape.equals("DIAMOND")) n1=2;
		else if(card1.shape.equals("HEART")) n1=1;
		else if(card1.shape.equals("CLOVER")) n1=0;
		if(card2.shape.equals("SPADE")) n2=3; 
		else if(card2.shape.equals("DIAMOND")) n2=2;
		else if(card2.shape.equals("HEART")) n2=1;
		else if(card2.shape.equals("CLOVER")) n2=0;
		
		//card1의 숫자가 더 큰 경우 participant 1의 승리
		if(card1.number>card2.number) {
			System.out.println("Participant 1 won!!");
		}
		//카드의 숫자가 같은 경우
		else if(card1.number == card2.number) {
			//카드의 모양이 같은 경우 무승부
			if(card1.shape.equals(card2.shape)) {
				System.out.println("draw");
				System.exit(0);
			}
			//card1의 모양이 우선순위를 가질 경우 participant 1 승리
			else if(n1>n2) {
				System.out.println("Participant 1 won!!");
			}
			//아닐 경우 participant 2 승리
			else {
				System.out.println("Participant 2 won!!");
			}
		}
		//card2의 숫자가 더 큰 경우
		else {
			System.out.println("Participant 2 won!!");
		}
	}
	
	public static void main(String[] args) {
		Card_after card1 = new Card_after(); //Card 객체 생성
		Card_after card2 = new Card_after(); //Card 객체 생성
		Card_after winner = new Card_after(); //Card 객체 생성
		Scanner scanner = new Scanner(System.in);		
		
		System.out.println("첫번째 카드를 입력하시오: ");
		card1.shape = scanner.next(); //첫번째 카드의 모양 받기
		card1.number = scanner.nextInt(); //첫번째 카드의 숫자 받기
		
		System.out.println("두번째 카드를 입력하시오: ");
		card2.shape = scanner.next(); //두번째 카드의 모양 받기
		card2.number = scanner.nextInt(); //두번째 카드의 숫자 받기
		
		card1.show(); //출력메소드 호출
		card2.show(); //출력메소드 호출
		winner.compare(card1,card2); //card1과 card2 크기 비교
		
		scanner.close(); //스캐너 종료
		}

}
