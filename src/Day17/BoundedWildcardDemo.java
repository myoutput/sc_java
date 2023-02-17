package Day17;

class Box<T> {
	private T ob; //변수 ob 타입을 T로 선언

	public void set(T o) { ob = o; } //T타입의 값 o를 ob에 대입

	public T get() { return ob; } //ob 리턴
}

public class BoundedWildcardDemo {

	// 24 + 37 을 더하는 코드 ( b1은 상위 클래스, b2,b3는 하위 클래스)
	public static void addBox(Box<? super Integer> b1, Box<? extends Integer> b2, Box<? extends Integer> b3)
	{
		b1.set(b2.get() + b3.get());
	}

	public static void main(String[] args) {
		Box<Integer> box1 = new Box<>(); //Integer로 형구체화
		box1.set(24); //24 set
		Box<Integer> box2 = new Box<>(); //Integer로 형구체화
		box2.set(37); //37 set
		Box<Integer> result = new Box<>(); //Integer로 형구체화
		result.set(0); //0 set

		addBox(result, box1, box2); //addBox에  result, box1, box2 넣기
		System.out.println(result.get()); //result get

	}

}

//61 출력