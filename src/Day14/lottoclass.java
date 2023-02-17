package Day14;

import java.util.Random;
import java.util.Scanner;

//로또 클래스
public class lottoclass {
	
	//랜덤 로또 번호 생성 메소드
	public static int[] lotto_num(){
		int array[] = new int[6]; //크기가 6인 배열
		Random rand = new Random(45); //고정된 시드의 랜덤객체 생성
		//for문을 통해 6개 뽑기
		for (int x = 0; x < 6; x++) {
			int n = (int) (rand.nextInt(45)+1); //1~45까지 랜덤 숫자 생성
			array[x] = n; //숫자를 매열에 넣기
			//중복인 숫자 제외
			for (int a = 0; a < x; a++) {
				if (array[x] == array[a]) {
					x--;
				}
			}
		}
		return array; //배열 리턴
	}
	
	//랜덤 로또 예측 번호 생성 메소드
	public static int[] rand_num() {
		int num[] = new int[6]; //크기가 6인 배열 생성
		//for문을 통해 6개 뽑기
		for (int x = 0; x < 6; x++) {
			int n = (int) (Math.random() * 45 + 1); //1~45까지 랜덤 숫자 생성
			num[x] = n; //n을 배열에 넣기
			//중복인 숫자 제외
			for (int a = 0; a < x; a++) {
				if (num[x] == num[a]) {
					x--;
				}
			}
		}
		return num; //배열 리턴
	}
	
	//몇 개를 맞혔는지 확인하는 메소드
	public static int count(int a[],int b[]) {
		int count=0;
		//두 배열의 원소를 비교하는 for문
		for (int z = 0; z < 6; z++) {
			for (int i = 0; i < 6; i++) {
				if (a[z] == b[i]) {
					count++; //두 배열의 원소가 같으면 count 증가
				}
			}
		}
		return count; //count 리턴
	}
	
	//출력 메소드1 (번호 출력)
	public static void show1(int a[]) {
		//for문을 통해 배열 원소 출력
		for(int i =0;i<6;i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	//출력 메소드2 (순위 출력)
	public static void show2(int count) {
		if (count == 6) { //count가 6면 1등 출력
			System.out.print("1등");
		} 
		else if (count == 5) { //count가 5면 2등 출력
			System.out.print("2등");
		}

		else if (count == 4) { //count가 4면 3등 출력
			System.out.print("3등");
		} 
		else if(count == 3) { //count가 3면 4등 출력
			System.out.print("4등");
		}
		else { // 그 외에는 당첨이 안됐습니다 출력
			System.out.print("당첨이 안됐습니다.");}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a[] = new int[6]; //크기가 6인 배열 생성
		int b[] = new int[6]; //크기가 6인 배열 생성
		int arr[] = new int[6]; //크기가 6인 배열 생성
		int answer, match;
		
		a = lotto_num(); //로또 번호 뽑아 a에 대입
		System.out.print("로또 번호 : ");
		show1(a); //출력 메소드1 호출
		
		b = rand_num(); //자동 예측 번호 뽑아 b에 대입
		System.out.print("<자동> 예측 번호 : ");
		show1(b); //출력 메소드1 호출
		
		answer = count(a,b); //a와 b 배열 비교
		System.out.print("결과 : ");
		show2(answer); //출력 메소드2 호출
		
		//스캐너로 로또 번호 받아 배열에 넣기
		System.out.print("\n<수동> 로또 번호를 입력하세요 : ");
		for (int i = 0; i < 6; i++) {
			int n = sc.nextInt();
			arr[i] = n;
		}
		
		match = count(a,arr); //a배열과 arr배열 비교
		System.out.print("결과 : ");
		show2(match); //출력 메소드2 호출
	}

}
