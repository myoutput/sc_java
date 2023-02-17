package Day_8;

import java.util.Random;

public class Card {
	enum Shape{SPADE,DIAMOND,HEART,CLOVER}; //모양으로 enum 선언
	Shape type;
	int num;
	
	//랜덤으로 숫자를 가져오는 메소드
	public static int rand_num() {
		
		int cardNumber;
		cardNumber = (int)(Math.random() * 13) + 1; //1~10까지 값 랜덤으로 뽑기
		
		return cardNumber; //cardNumber 반환
	}
	
	//랜덤으로 모양을 가져오는 메소드
	public static Shape rand_shape() {
		return Shape.values()[new Random().nextInt(Shape.values().length)];}
	
	//숫자와 모양 받기
	public Card(int num,Shape type) {
		this.num = num; //숫자 저장
		this.type = type; //모양 저장
	}
	
	//복사 메소드
	public static Card[]hardCopy(Card[]a){
		if(a==null) return null;
		Card[]b = new Card[a.length]; //새 배열 만들기
		//for문을 이용해 숫자와 모양 복사
		for(int i=0;i<a.length;i++) {
			b[i] = new Card(a[i].num,a[i].type);
		}
		return b; //b배열 반환
	}
	
	//정렬해주는 메소드
	public static Card[]sorting(Card[]b) {
		//숫자를 기준으로 내림차순으로 정렬
		for(int i =0;i<b.length;i++) {
			for(int j=i+1;j<b.length;j++) {
				//b[i]의 숫자가 b[j]의 숫자보다 작다면 자리 바꾸기
				if(b[i].num<b[j].num) {
					Card tmp = b[i];
					b[i] = b[j];
					b[j] = tmp;
				}
			}
		}
		// 숫자로만 정렬된 배열 중 숫자가 같을 경우 모양 우선순위 정하기
		for(int k =0;k<(b.length)-1;k++) {
			if(b[k].num==b[k+1].num) { //숫자가 같다면
				if(b[k].type.ordinal()>b[k+1].type.ordinal()) {
					Card tmp2 = b[k];
					b[k] = b[k+1];
					b[k+1] = tmp2;
				}
			}
		}
		return b;
	}
	
	public static void show(Card[]arr) {
		for(int i =0;i<arr.length;i++) {
			if(arr[i].num == 1) {
				System.out.print("["+arr[i].type + " "+ "Ace] ");
			}
			//숫자가 11이면 J로 출력
			else if(arr[i].num == 11) {
				System.out.print("["+arr[i].type + " "+ "J] ");
			}
			//숫자가 12이면 Q로 출력
			else if(arr[i].num == 12) {
				System.out.print("["+arr[i].type + " "+ "Q] ");
			}
			//숫자가 13이면 K로 출력
			else if(arr[i].num == 13) {
				System.out.print("["+arr[i].type + " "+ "K] ");
			}
			//숫자와 모양 출력
			else {
				System.out.print("["+arr[i].type+" "+arr[i].num+"] ");
			}
			
		}
	}
	
	public static void main(String[] args) {
		
		Card [] a = new Card[10]; //객체 배열 생성
		
		//랜덤으로 받은 숫자와 모양 배열에 넣기
		for(int i =0;i<a.length;i++) {
			int num = rand_num();
			Shape type = rand_shape();
			a[i] = new Card(num,type);
		}
		
		Card [] b = hardCopy(a); //a배열을 복사한 b배열 만들기
		
		System.out.println("정렬 전: ");
		show(a);
//		System.out.println(" ");
//		show(b); //b배열이 복사 완료되었는지 확인용
		
		Card [] c = sorting(b); //b배열 정렬

		System.out.println(" ");
		System.out.println("정렬 후: ");
//		show(a); //a배열은 변하지 않았는지 확인용
//		System.out.println(" ");
		show(c);
	}

}
