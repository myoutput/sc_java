package Day16;

public class GenericMethod {

	//배열 값을 출력하는 제너릭 메소드
	public static <T> void printArray(T[] arr) {
		//for문으로 배열 출력
		for (int i =0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
			}
			System.out.println();
	}
	public static void main(String[] args) {
		
		Integer[] iarr = {1 ,2 ,3 ,4 ,5}; //Integer값이 담긴 배열
		Double[] darr = {1.1, 1.2, 1.3, 1.4, 1.5}; //Double값이 담긴 배열
		Character []carr = {'D','R','E','A','M'}; //Character값이 담긴 배열
		String[] sarr = {"플라스틱", "파우더", "재료", "클래스"}; //String값이 담긴 배열

		//메소드 호출
		printArray(iarr);
		printArray(darr);
		printArray(carr);
		printArray(sarr);
	}

}
