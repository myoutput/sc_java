package Day23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class Card {
	String shape;
	int num;

	//생성자
	public Card(String shape, int num) {
		this.shape = shape;
		this.num = num;
	}

	public String toString() {
		// 숫자가 1이면 Ace로 출력
		if (num == 1) {
			return("(" + shape + " " + "Ace" + ")");
		}
		// 숫자가 11이면 J로 출력
		else if (num == 11) {
			return("(" + shape + " " + "J" + ")");
		}
		// 숫자가 12이면 Q로 출력
		else if (num == 12) {
			return("(" + shape + " " + "Q" + ")");
		}
		// 숫자가 13이면 K로 출력
		else if (num == 13) {
			return("(" + shape + " " + "K" + ")");
		}
		else {
			return ("(" + shape + " " + num + ")");
		}
	}
}

//덱 클래스
class Deck {
	ArrayList<Card> deck = new ArrayList<Card>();
	String shape[] = { "CLOVER", "DIAMOND", "HEART", "SPADE" };
	
	int num[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };

	//덱에 추가
	public Deck() {
		for (int i = 0; i < shape.length; i++) {
			for (int j = 0; j < num.length; j++) {
				deck.add(new Card(shape[i], num[j]));
			}
		}
	}

	//셔플
	public void shuffle() {
		Collections.shuffle(deck);
	}

	//일곱장씩 중복없이 나눠주기 (7번 반복)
	public ArrayList deal() {
		ArrayList<Card> dealcard = new ArrayList<Card>();

		for (int i = 0; i < 7; i++) {
			dealcard.add(deck.remove(0));
		}

		return dealcard;
	}
}

//플레이어 클래스
class Player {
	ArrayList<Card> list = new ArrayList<Card>();

	public void getCard(ArrayList card) {
		list = card;
	}

	//출력메소드
	public void showCards() {

		System.out.println(list);
	}

	public int game(Player p2) {

		Random random = new Random();
		int randomIndex = random.nextInt(list.size()); //랜덤값 뽑기
		
		//랜덤값에 따른 카드객체 뽑기
		Card player1 = list.get(randomIndex);
		System.out.println("My Card: " + player1);

		//랜덤값에 따른 카드객체 뽑기
		Card player2 = p2.list.get(randomIndex);
		System.out.println("Your Card: " + player2);

		int n1 = 0,n2 = 0;
		if(player1.shape.equals("SPADE")) n1=3; 
		else if(player1.shape.equals("DIAMOND")) n1=2;
		else if(player1.shape.equals("HEART")) n1=1;
		else if(player1.shape.equals("CLOVER")) n1=0;
		if(player2.shape.equals("SPADE")) n2=3; 
		else if(player2.shape.equals("DIAMOND")) n2=2;
		else if(player2.shape.equals("HEART")) n2=1;
		else if(player2.shape.equals("CLOVER")) n2=0;
		
		// 나의 숫자가 더 큰 경우 나의 승리
		if (player1.num > player2.num) {
			System.out.println("I win!!");
		}
		// 카드의 숫자가 같은 경우
		else if (player1.num == player2.num) {
			// 나의 모양의 값이 크면 나의 승리
			if (n1>n2) {
				System.out.println("I win!!");
			}
			// 아닐 경우 상대방 승리
			else {
				System.out.println("You win!!");
			}
		}
		// 상대의 숫자가 더 큰 경우
		else {
			System.out.println("You win!!");
		}
		return 0;
	}
}

public class CardGame {

	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.shuffle();

		Player p1 = new Player();
		Player p2 = new Player();

		p1.getCard(deck.deal());
		p2.getCard(deck.deal());

		p1.showCards();
		p2.showCards();

		p1.game(p2);
	}

}
