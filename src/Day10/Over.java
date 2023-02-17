package Day10;

import java.util.Random;

//Card 클래스
class Card{
	static int cardNumber; 
	static int type;
	
	//랜덤으로 숫자를 가져오는 메소드 1
	public static int rand_num() {		
		int Number;
		Number = (int)(Math.random() * 13) + 1; //1~13까지 숫자 랜덤 뽑기
		return Number;
	}
	
	//랜덤으로 숫자를 가져오는 메소드 2
	public static int rand_type() {
		int Type;
		Type = (int)(Math.random() * 4) + 1; //1~4까지 숫자 랜덤 뽑기
		return Type;
	}
	
	//매개 변수 없는 Card 생성자
	public Card() {
		this(rand_type(),rand_num()); //생성자 호출
	}
	
	//랜덤으로 뽑은 숫자들을 넣는 생성자
	public Card(int rand_type, int rand_num) {
		cardNumber = rand_num;
		type = rand_type;
	}
	
	//출력 메소드
	public void show() {
		System.out.println(type + " "+cardNumber);
	}
	
}

//Card 클래스를 상속받은 OneCard 클래스
class OneCard extends Card{
	enum Shape{SPADE,DIAMOND,HEART,CLOVER}; //모양으로 enum 선언
	Shape shape;
	int a,b;
	
	//매개변수 없는 OneCard 생성자
	public OneCard() {
		this(type,cardNumber); //생성자 호출
	}
	
	//type과 num을 매개변수로 가지는 OneCard 생성자
	public OneCard(int type,int num) {
		super(type,num); //Card의 생성자 Card(int rand_type, int rand_num)호출
		this.a = type-1; //a에 type-1 대입
		this.b = num; //b에 num 대입
	}
	
	//출력 메소드 (오버라이딩)
	public void show() {
		Shape[]values = Shape.values(); //Shape가 가지고 있는 값을 배열 형태로
		//숫자가 1이면 Ace로 출력
		if(b == 1) {
			System.out.println(values[a] + " "+ "Ace");
		}
		//숫자가 11이면 J로 출력
		else if(b == 11) {
			System.out.println(values[a] + " "+ "J");
		}
		//숫자가 12이면 Q로 출력
		else if(b == 12) {
			System.out.println(values[a] + " "+ "Q");
		}
		//숫자가 13이면 K로 출력
		else if(b == 13) {
			System.out.println(values[a] + " "+ "K");
		}
		//숫자와 모양 출력
		else {
			System.out.println(values[a] + " "+ b);
		}
	}
	
}

class Uno extends Card{
	enum Color{Red, Yellow, Green, Blue}; //색깔로 enum 선언
	Color color;
	int a,b;
	
	//매개변수 없는 Uno 생성자
	public Uno() {
		this(type,cardNumber);
	}
	
	//color와 num을 매개변수로 가지는 Uno 생성자 
	public Uno(int color,int num) {
		super(color,num); //Card의 생성자 Card(int rand_type, int rand_num)호출
		this.a = color-1; //a에 color-1 대입
		this.b = num; //b에 num 대입
	}
	
	//출력 메소드
	public void show() {
		Color[]values = Color.values(); //Color가 가지고 있는 값을 배열 형태로
		
		//숫자가 11이면 Skip으로 출력
		if(b == 11) {
			System.out.println(values[a] + " "+ "Skip");
		}
		//숫자가 12이면 Reverse로 출력
		else if(b == 12) {
			System.out.println(values[a] + " "+ "Reverse");
		}
		//숫자가 13이면 Draw로 출력
		else if(b == 13) {
			System.out.println(values[a] + " "+ "Draw");
		}
		//숫자와 모양 출력
		else {
			System.out.println(values[a] + " "+ b);
		}
	}
}

public class Over {
	
	public static void main(String[] args) {
//		//업캐스팅
//		Card c1 = new Card();
//		Card c2 = new OneCard();
//		Card c3 = new Uno();
//		Card[]c = {c1,c2,c3}; //객체 배열에 담기
		
		Card[]c = {new Card(),new OneCard(),new Uno()}; //업캐스팅, 객체 배열로 배열 정의
		for(int i =0;i<c.length;i++) {
			c[i].show(); //for문을 이용하여 출력메소드 호출
		}
		
	}

}

