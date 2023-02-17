package Day_5;

import java.util.Random;
import java.util.Scanner;

public class Quiz {
	

	public static void main(String[] args) {
		
		Random rand = new Random();
		Scanner scanner = new Scanner(System.in);
		
		
		String[]shape = {"SPADE","DIAMOND","HEART","CLOVER"};
		String[]num = {"2","3","4","5","6","7","8","9","10","J","Q","K","Ace"};
		
		System.out.println("몇 명이서 경쟁하시겠습니까? ");
		int p = scanner.nextInt();
		
		
		for(int i=0;i<p;i++) {
			System.out.println("Participant "+(i+1)+": "+ shape[rand.nextInt(4)] + " " +num[rand.nextInt(13)]);
		}
		
		
		
		
		//int ramnd = (int)(Math.random()*12)+1;
		
		

	}

}
