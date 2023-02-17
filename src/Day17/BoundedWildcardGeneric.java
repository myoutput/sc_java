package Day17;

class Boxx<T> {
	private T ob; //변수 ob 타입을 T로 선언

	public void set(T o) { ob = o; } //T타입의 값 o를 ob에 대입

	public T get() { return ob; } //ob 리턴
}

public class BoundedWildcardGeneric {

	//box와 con에 같은 것이 들어가있는지 확인하기
	public static <T> boolean compBox(Boxx<? extends T> box, T con) {
		T bc = box.get();
		T ob = con; //ob라는 새로운 변수에 단순하게 con을 대입한 후에 비교
//		box.set(con); //굳이 새로 set을 써서 받아올 필요가 없음
		return bc.equals(con); //같은지 비교
	}

	public static void main(String[] args) {

		Boxx<Integer> box1 = new Boxx<>(); //Integer로 형 구체화
		box1.set(25); //24 set
		
		Boxx<String> box2 = new Boxx<>(); //String으로 형 구체화
		box2.set("Moly"); //Poly set 

		//box1과 25가 같으면 다음과 같이 출력
		if (compBox(box1, 25))
			System.out.println("상자 안에 25 저장");

		//box2와 Moly가 같으면 다음과 같이 출력
		if (compBox(box2, "Moly"))
			System.out.println("상자 안에 Moly 저장");

		System.out.println(box1.get());
		System.out.println(box2.get());

	}

}

//24 Poly 출력?
