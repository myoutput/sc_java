package Day_6;

import java.util.Scanner;

public class Card_before {
	int number,j;
	String shape;
	String n;
	int won=0;
	int k=0;
	
	public Card_before() {}
	
	public void show() {
		System.out.println(shape + " "+ number);
	}
	
	public void compare(int a, String b, int c, String d) {
		
		
		for(int i =0;i<2;i++) {
			if(a>c) {
				j=i+1;
				break;
			}
			else if(a == c) {
				if(b.equals(d)) {
					System.out.println("draw");
					System.exit(0);
				}
				else if(b.equals("SPADE")) {
					j = i+1;
					break;
				}
				else if(b.equals("DIAMOND")) {
					if(d.equals("SPADE")) {
						j = i+2;
						break;
					}
					else {
						j = i+1;
						break;
					}
				}
				else if(b.equals("HEART")) {
					if(d.equals("SPADE")||d.equals("DIAMOND")) {
						j = i+2;
						break;
					}
					else {
						j = i+1;
						break;
					}
				}				
				else {
					j = i+2;
					break;
				}

			}
			else {
				j = i+2;
				break;
			}
		}
		System.out.println("Partipant "+j+" won!!");
	}
	
	public static void main(String[] args) {
		Card_before card1 = new Card_before();
		Card_before card2 = new Card_before();
		Card_before winner = new Card_before();
		Scanner scanner = new Scanner(System.in);		
		
		System.out.println("첫번째 카드를 입력하시오: ");
		card1.shape = scanner.next();
		card1.number = scanner.nextInt();
		
		System.out.println("두번째 카드를 입력하시오: ");
		card2.shape = scanner.next();
		card2.number = scanner.nextInt();
		
		card1.show();
		card2.show();
		winner.compare(card1.number, card1.shape, card2.number, card2.shape);
		}
		
	}

