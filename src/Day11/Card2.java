package Day11;

import java.util.Random;

//인터페이스 구현
public class Card2 implements Comparable<Card2> {

	enum Shape {
		SPADE, DIAMOND, HEART, CLOVER
	}; // 모양으로 enum 선언

	Shape shape;
	int number;

	// 카드의 내용을 출력하는 메소드
	void show() {
		// 숫자가 1이면 Ace로 출력
		if (number == 1) {
			System.out.println(shape + " " + "Ace");
		}
		// 숫자가 11이면 J로 출력
		else if (number == 11) {
			System.out.println(shape + " " + "J");
		}
		// 숫자가 12이면 Q로 출력
		else if (number == 12) {
			System.out.println(shape + " " + "Q");
		}
		// 숫자가 13이면 K로 출력
		else if (number == 13) {
			System.out.println(shape + " " + "K");
		}
		// 숫자와 모양 출력
		else {
			System.out.println(shape + " " + number);
		}
	}

	// 랜덤으로 숫자를 가져오는 메소드
	public static int rand_num() {

		int objNumber;
		objNumber = (int) (Math.random() * 13) + 1; // 1~13까지 값 랜덤으로 뽑기

		return objNumber; // objNumber 반환
	}

	// 랜덤으로 모양을 가져오는 메소드
	public static Shape rand_shape() {
		return Shape.values()[new Random().nextInt(Shape.values().length)];
	}

	// 매개변수 없는 Card2 메소드
	public Card2() {
		this(rand_shape(), rand_num()); // 둘다 랜덤으로 대입
	}

	// 매개변수 2개인 Card2 메소드
	public Card2(Shape shape, int number) {
		this.shape = shape; // 입력된 모양 대입
		this.number = number; // 입력된 숫자 대입
	}

	public static void main(String[] args) {

		System.out.println("Generate a random obj : ");
		Card2 c1 = new Card2(); // 객체 생성
		Card2 c2 = new Card2(); // 객체 생성
		c1.show(); // 출력 메소드 호출
		c2.show(); // 출력 메소드 호출
		c1.compareTo(c2); // c1와 c2 비교

	}

	@Override
	public int compareTo(Card2 o) {

		// this의 숫자가 더 큰 경우 participant 1의 승리
		if (this.number > o.number) {
			System.out.println("Participant 1 won!!");
		}
		// 카드의 숫자가 같은 경우
		else if (this.number == o.number) {
			// 카드의 모양이 같은 경우 무승부
			if (this.shape.equals(o.shape)) {
				System.out.println("draw");
				System.exit(0);
			}
			// this의 모양의 인덱스 값이 작으면 participant 1 승리
			else if (this.shape.ordinal()<o.shape.ordinal()) {
				System.out.println("Participant 1 won!!");
			}
			// 아닐 경우 participant 2 승리
			else {
				System.out.println("Participant 2 won!!");
			}
		}
		// o의 숫자가 더 큰 경우
		else {
			System.out.println("Participant 2 won!!");
		}
		return 0;
	}

}
