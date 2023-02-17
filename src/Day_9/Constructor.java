package Day_9;

//Car 클래스
class Car {
    int gasolineGauge; // 잔여 가솔린
    //Car의 생성자
    public Car(int g) { 
    	this.gasolineGauge=g; //받은 g 값을 gasolineGauge에 넣기
    }
    //출력 메소드
    public void showCar() {
    	System.out.println("잔여 가솔린 : "+gasolineGauge+" ");
    }
}

//Car을 상속받은 HybridCar 클래스
class HybridCar extends Car {  
    double electricGauge; //잔여 전기량
    public HybridCar(int g,double e) {
    	super(g); //Car의 생성자 Car(int g)호출
    	this.electricGauge=e; //받은 e값 electricGauge에 넣기
    }
    //출력 메소드
    public void showPoint() {
    	showCar(); //Car 클래스의 showCar()호출
    	System.out.println("잔여 전기량 : "+electricGauge+" ");
    }
}

//HybridCar을 상속받은 HybridWaterCar 클래스
class HybridWaterCar extends HybridCar {   
    int waterGauge; //잔여 워터량
    
    public HybridWaterCar(double e, int w) {
    	super(0,e); //HybridCar의 생성자 HybridCar(int g, double e)호출, g값이 없으므로 0대입
    	this.waterGauge = w; //받은 w값 waterGauge에 넣기
    }
    
    public HybridWaterCar(int g,double e,int w) {
    	super(g,e); //HybridCar의 생성자 HybridCar(int g, double e)호출
    	this.waterGauge=w; //받은 w값 waterGauge에 넣기
    }

    //출력메소드
    public void showCurrentGauge() {
    	showPoint(); //HybridCar의 showPoint()호출
    	System.out.println("잔여 워터량 : "+waterGauge);
    }

}

public class Constructor {

	public static void main(String[] args) {
		
		HybridWaterCar hwCar1 = new HybridWaterCar(4.2, 2); //객체 생성, 숫자 대입
		hwCar1.showCurrentGauge(); //출력 메소드 호출
		

	    HybridWaterCar hwCar2 = new HybridWaterCar(9, 5.1, 7); //객체 생성, 숫자 대입
	    hwCar2.showCurrentGauge(); //출력 메소드 호출
	}
}
