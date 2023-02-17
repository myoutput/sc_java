package Day12;

import java.util.Scanner;

//Phone 클래스
class Phone{
	String name; //이름
	String number; //전화번호
	public Phone(String name, String number) {
		this.name = name; //이름 저장
		this.number = number; //전화번호 저장
	}
	//출력 메소드
	public void show() {
		System.out.println("이름 : "+name); //이름 출력
		System.out.println("전화번호 : "+number); //전화번호 출력
	}
}

//Phone2를 상속받은 PhoneUniv
class PhoneUniv extends Phone{
	String major; //전공
	String grade; //학년

	public PhoneUniv(String name, String number,String major,String grade) {
		super(name, number); //Phone의 생성자 Phone(int name, number)호출
		this.major = major; //전공 저장
		this.grade = grade; //학년 저장
	}

	//출력 메소드
	public void show() {
		super.show(); //정적 바인딩
		System.out.println("전공 : "+major); //전공 출력
		System.out.println("학년 : "+grade); //학년 출력
	}
}

//Phone2를 상속받은 PhoneComp
class PhoneComp extends Phone{
	String company; //회사명

	public PhoneComp(String name, String number, String company) {
		super(name, number); //Phone의 생성자 Phone(int name, number)호출
		this.company = company; //회사 저장
	}

	//출력 메소드
	public void show() {
		super.show(); //정적 바인딩
		System.out.println("회사명 : "+company); //회사명 출력
	}

}

//PhoneManager 클래스
class PhoneManager{
	final int MAX = 100; //상수 정의
	Phone[] ph = new Phone[MAX]; //객체 배열 생성
	int count = 0;
	Scanner sc = new Scanner(System.in);
	
	//출력 메소드
	public static void show() {
		System.out.println("번호를 선택하시오.");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 프로그램 종료");
	}
	
	//데이터 입력
	public void input() {
		System.out.println("데이터 입력을 시작합니다..");
		System.out.println("1. 일반, 2. 대학, 3. 회사");
		System.out.print("선택>> ");
		//choice로 번호 받기
		int choice = sc.nextInt();
		sc.nextLine(); //엔터 처리
		
		Phone p = null;
		
		switch(choice) {
		//1을 선택했을 경우
		case 1:
			//이름 입력받기
			System.out.print("이름 : ");
			String name = sc.nextLine();
			//전화번호 입력받기
			System.out.print("전화번호 : ");
			String number = sc.nextLine(); 
			
			p = new Phone(name,number); //Phone에 name과 number 넣은 객체 저장
			break;
		//2를 선택했을 경우
		case 2:
			//이름 입력받기
			System.out.print("이름 : ");
			String name2 = sc.nextLine();
			//전화번호 입력받기
			System.out.print("전화번호 : ");
			String number2 = sc.nextLine();
			//전공 입력받기
			System.out.print("전공 : ");
			String major = sc.nextLine();
			//학년 입력받기
			System.out.print("학년 : ");
			String grade = sc.nextLine();
			p = new PhoneUniv(name2,number2,major,grade); //PhoneUniv에 name2과 number2, major, grade 넣은 객체 저장
			break;
		//3을 선택했을 경우
		case 3:
			//이름 입력받기
			System.out.print("이름 : ");
			String name3 = sc.nextLine();
			//전화번호 입력받기
			System.out.print("전화번호 : ");
			String number3 = sc.nextLine();
			//회사명 입력받기
			System.out.print("회사명 : ");
			String company = sc.nextLine();
			p = new PhoneComp(name3,number3,company); //PhoneComp에 name3과 number3, company 넣은 객체 저장
			break;
		}
		ph[count] = p; //객체 배열에 넣기
		System.out.println("입력이 완료되었습니다.");
		count ++; //count 증가
	}
	
	//검색 메소드
	public void searchData() {
		System.out.println("검색을 시작합니다.");
		System.out.print("이름 : ");
		String name = sc.nextLine(); //이름 입력받기
		int index = search(name); //name을 search에 대입 후 리턴값 index에 대입
		//index가 0보다 작을 경우
		if(index < 0) {
			System.out.println("해당 이름의 자료가 없습니다.\n");
		}
		else {
			ph[index].show(); //내용 출력
			System.out.println("검색하였습니다.\n");
		}
	}

	public int search(String name) {
		for(int idx=0;idx<MAX;idx++) {
			Phone t = ph[idx];
			if(t == null) return -1; //t가 null이면 -1 리턴
			//name과 같은 것이 있으면 idx 리턴
			if(name.compareTo(t.name)==0) 
				return idx;
		}
		return -1; //같은 것이 없으면 -1 리턴
	}
	
	//삭제 메소드
	public void delData() {
		System.out.print("삭제하실 분의 이름을 입력해주세요: ");
		String name = sc.nextLine(); //이름 입력받기
		int index = search(name); //name을 search에 대입 후 리턴값 index에 대입
		//index값이 0보다 작은 경우
		if(index<0) {
			System.out.println("해당 이름의 자료가 없습니다.\n");
		}
		else {
			if(index == count-1) { //맨끝에 것을 삭제할 때
				ph[index] = ph[index+1];
			}
			else {
				for(int idx = index;idx<count;idx++) { //index부터 count까지 반복하며 앞으로 이동
					ph[idx] = ph[idx+1];
					count--; //count 감소
				}
				
			}
			System.out.println("데이터 삭제가 완료되었습니다.");
		
		}
	}
}
public class PhoneBookkk {
public static void main(String[] args) {
		
		PhoneManager manager = new PhoneManager(); //PhoneManager의 객체 생성

		//무한 반복
		while(true) {
			manager.show();
			int n = manager.sc.nextInt();
			manager.sc.nextLine();

			switch(n) {
			case 1:
				manager.input(); //1 선택시 manager의 input호출
				break;
			case 2:
				manager.searchData(); //2 선택시 manager의 searchData 호출
				break;
			case 3:
				manager.delData(); //3 선택시 manager의 delData호출
				break;
			case 4:
				System.out.println("시스템 종료");
				return; //4 선택시 시스템 종료
			default:
				System.out.println("잘못 선택하셨습니다.");
				break; //잘못 선택시 잘못 선택하셨습니다. 출력
			}
		}
	}

}



























