package Day_5;

import java.util.Scanner;

public class twopeople {

	public static void main(String[] args) {
		int number[];
		boolean swit[];
		int a, b;
				
		number = new int[52];
		swit = new boolean[52];
		for (int i = 0; i < swit.length; i++) {
			swit[i] = false;
		}
		a = 0;
		
		while(a < 52) {
			b = (int)(Math.random() * 52);
			if(swit[b] == false) {
				swit[b] = true;
				number[a] = b;
				a++;
			}
		}
		
		Scanner scanner = new Scanner(System.in);
		
		int cardNumber;	
		int shape;
		int won = 0;
		int n = -1;
		int count=0;
		System.out.println("몇 명이서 경쟁하시겠습니까? ");
		int p = scanner.nextInt();
		
		for (int i = 0; i < p; i++) {
			System.out.print("Participant "+(i+1)+": ");
		
			shape = number[i] / 13;
			
			switch(shape) {
				case 3:
					System.out.print("SPADE");
					break;
				case 2:
					System.out.print("DIAMOND");
					break;
				case 1:
					System.out.print("HEART");
					break;
				case 0:
					System.out.print("CLOVER");
					break;
			}
			

			System.out.print(" ");
			cardNumber = number[i] % 13 + 1;
			
			if(cardNumber == 1) {
				System.out.println("A");
			}
			else if(cardNumber == 11) {
				System.out.println("J");
			}
			else if(cardNumber == 12) {
				System.out.println("Q");
			}
			else if(cardNumber == 13) {
				System.out.println("K");
			}
			else {
				System.out.println(cardNumber);
			}
			
			if(cardNumber>won) {
				won = cardNumber;
				count++;
			}
			
			else if(cardNumber == won) {
				if(n==shape) {
					System.out.println("draw");
					System.exit(0);
				}
				else if(n<shape) {
					n=shape;
					count++;
				}

			}
			
		}
		System.out.println("Partipant "+count+" won!!");
	}

}
