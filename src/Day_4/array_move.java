package Day_4;

public class array_move {
	//shift 메서드
	public static int[][] shift(int[][]arr) {
		int temp; //담을 원소 변수
		int tem[]; //원소를 담는 배열 선언
		tem= new int[arr[0].length]; //배열 생성(정방향 배열이라 arr[0].length로 진행하였음, 마지막 행의 길이로 진행해도 됨)
		//마지막 행의 원소 저장하는 for문
		for(int i=0;i<arr[0].length;i++) {
			temp = arr[arr.length-1][i]; //temp에 마지막 행의 원소를 대입
			tem[i] = temp; //temp를 tem배열에 저장
		}
		//마지막 행을 제외한 나머지 행을 한칸씩 shift
		for(int i=arr.length-2;i>=0;i--) { //마지막에서 두번째 행부터 이동시킴
			for(int j=0; j<arr[i].length;j++) {
				arr[i+1][j]=arr[i][j]; //열은 같고 행은 한칸씩 늘림
			}
		}
		//tem에 저장했던 수를 첫번째 행에 대입
		for(int i=0;i<arr[0].length;i++) {
			arr[0][i]=tem[i];
		}
		return arr;
	}
	
	//출력하는 메서드
	public static void print(int[][]ar) {
		//중첩 for문을 이용하여 출력
		for(int i =0;i<ar.length;i++) {
			for(int j =0;j<ar[i].length;j++) {
				System.out.print(ar[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int [][] intArray = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		//for문을 이용하여 3차까지 진행
		for(int i=1;i<=3;i++) {
			System.out.printf("%d차 shift...\n", i);
			shift(intArray);
			print(intArray);
			System.out.println();
		}
		
		
	}

}
