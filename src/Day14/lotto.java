package Day14;

import java.util.Random;
import java.util.Scanner;

public class lotto {
	public static void main(String[] args) {
		int array[] = new int[6];
		int num[] = new int[6];
		int co[] = new int[6];
		int count = 0;

		Random rand = new Random(45);
		for (int x = 0; x < 6; x++) {
			int n = (int) (rand.nextInt(45));
			array[x] = n;
			for (int a = 0; a < x; a++) {
				if (array[x] == array[a]) {
					x--;
				}
			}
		}
		for (int i = 0; i < 6; i++) {
			System.out.print(array[i] + " ");
		}

		System.out.println();

		for (int y = 0; y < 6; y++) {
			int m = (int) (Math.random() * 45 + 1);
			num[y] = m;
			for (int a = 0; a < y; a++) {
				if (num[y] == num[a]) {
					y--;
				}
			}

		}
		for (int i = 0; i < 6; i++) {
			System.out.print(num[i] + " ");
		}

		System.out.println();

		for (int z = 0; z < 6; z++) {
			for (int i = 0; i < 6; i++) {
				if (array[z] == num[i]) {
					co[z] = num[i];
				}
			}
		}
		for (int j = 0; j < 6; j++) {
			if (co[j] != 0) {
				count++;
			}
		}
		count = 0;
		if (count == 6) {
			System.out.print("1등");
		} else if (count == 5) {
			System.out.print("2등");
		}

		else if (count == 4) {
			System.out.print("3등");
		} else {
			System.out.print("당첨이 안됐습니다.");

			int arr[];
			arr = new int[6];
			int co2[];
			co2 = new int[6];
			Scanner scanner = new Scanner(System.in);
			System.out.print("\n로또 번호를 입력하세요 : ");
			for (int e = 0; e < 6; e++) {
				int C = scanner.nextInt();
				arr[e] = C;
			}
			for (int z = 0; z < 6; z++) {
				for (int i = 0; i < 6; i++) {
					if (array[z] == arr[i]) {
						co2[z] = num[i];
					}
				}
			}
			for (int j = 0; j < 6; j++) {
				if (co2[j] != 0) {
					count++;
				}
			}

			if (count == 6) {
				System.out.print("1등");
			} else if (count == 5) {
				System.out.print("2등");
			}

			else if (count == 4) {
				System.out.print("3등");
			} 
			else {
				System.out.print("당첨이 안됐습니다.");
			}
		}
	}
}
