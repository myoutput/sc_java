package Day16;

//플라스틱 재료
class Plastic {
	public Plastic() {
		System.out.println("플라스틱");
	}
}

//플라스틱을 재료로 쓰는 프린터
class PrinterPlastic {
	private Plastic material;

	public Plastic getMaterial() {
		return material;
	}

	public void setMaterial(Plastic material) {
		this.material = material;
	}
}

//재료 파우더
class Powder {
	public Powder() {
		System.out.println("파우더");
	}
}

//파우더를 재료로 쓰는 프린터
class PrinterPowder {
	private Powder material;

	public Powder getMaterial() {
		return material;
	}

	public void setMaterial(Powder material) {
		this.material = material; 
	}
}

//재료 출력 클래스
class PrinterGeneric<T>{
	private T ob; //변수 ob 타입을 T로 선언
	
	public void set(T o) {
		ob = o; //T 타입의 값 o를 ob에 지정
	}
	public T get() {
		return ob; //T 타입의 값 ob 리턴
	}
}

public class Generic {
	public static void main(String[] args) {
			PrinterGeneric<Plastic> pl = new PrinterGeneric<Plastic>(); //obj타입(Plastic)으로 형구체화
			PrinterGeneric<Powder> po = new PrinterGeneric<Powder>(); //obj타입(Powder)으로 형구체화
			
			//재료를 담기
			pl.set(new Plastic());
			po.set(new Powder());
			
			//재료 꺼내오기
			Plastic p = pl.get();
			Powder pp = po.get();
			
	}

}
