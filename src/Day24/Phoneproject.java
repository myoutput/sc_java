package Day24;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;

//Phone 클래스
class Phone{
	String name; //이름
	String number; //전화번호
	public Phone(String name, String number) {
		this.name = name; //이름 저장
		this.number = number; //전화번호 저장
	}
}

//Phone를 상속받은 PhoneUniv
class PhoneUniv extends Phone{
	String major; //전공
	String grade; //학년

	public PhoneUniv(String name, String number,String major,String grade) {
		super(name, number); //Phone의 생성자 Phone(int name, number)호출
		this.major = major; //전공 저장
		this.grade = grade; //학년 저장
	}
}

//Phone를 상속받은 PhoneComp
class PhoneComp extends Phone{
	String company; //회사명

	public PhoneComp(String name, String number, String company) {
		super(name, number); //Phone의 생성자 Phone(int name, number)호출
		this.company = company; //회사 저장
	}
}

//PhoneManager 클래스
class PhoneManager{
	final int MAX = 100; //상수 정의
	boolean dataChange;
	HashMap<String, Phones>map; //해쉬맵
	Scanner sc = new Scanner(System.in);
	
	//출력 메소드
	public static void show() {
		System.out.println("번호를 선택하시오.");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 전화번호부 백업");
		System.out.println("5. 전화번호부 가져오기");
		System.out.println("6. 프로그램 종료");
	}
	
	//데이터 입력
	public void input() {
		System.out.println("데이터 입력을 시작합니다..");
		System.out.println("1. 일반, 2. 대학, 3. 회사");
		System.out.print("선택>> ");
		//choice로 번호 받기
		int choice = sc.nextInt();
		sc.nextLine(); //엔터 처리
		
		if(map==null){ //파일이 없거나 입출력 오류일 때
			map = new HashMap<>();
		}
		
		Phones p = null;
		
		switch(choice) {
		//1을 선택했을 경우
		case 1:
			//이름 입력받기
			System.out.print("이름 : ");
			String name = sc.nextLine();
			//전화번호 입력받기
			System.out.print("전화번호 : ");
			String number = sc.nextLine(); 
			
			p = new Phones(name,number); //Phone에 name과 number 넣은 객체 저장
			map.put(name, p); //맵에 넣기
			
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
			p = new Phones(name2,number2,major,grade); //PhoneUniv에 name2과 number2, major, grade 넣은 객체 저장
			map.put(name2, p); //맵에 넣기
			
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
			p = new Phones(name3,number3,company); //PhoneComp에 name3과 number3, company 넣은 객체 저장
			map.put(name3, p); //맵에 넣기
			break;
		}
		
		System.out.println("입력이 완료되었습니다.");
		
	}
	
	//검색 메소드
	public void search() {
		System.out.println("검색을 시작합니다.");
		System.out.print("이름 : ");
		String name = sc.nextLine(); //이름 입력받기
		if(map==null){ //파일이 없거나 입출력 오류일때
			map = new HashMap<>();
		}
		//name과 같은 것이 없다면 "해당 이름의 자료가 없습니다." 출력
		if(map.containsKey(name)!=true) {
			System.out.println("해당 이름의 자료가 없습니다.\n");
			return;
		}
		
		System.out.println(map.get(name)); //name 키값에 해당하는 맵출력
		System.out.println("검색하였습니다.");
	}
	
	//삭제 메소드
	public void delData() {
		System.out.print("삭제하실 분의 이름을 입력해주세요: ");
		String name = sc.nextLine(); //이름 입력받기
		//name과 같은 것이 없다면 "해당 이름의 자료가 없습니다." 출력
		if(map.containsKey(name)!=true) {
			System.out.println("해당 이름의 자료가 없습니다.\n");
			return;
		}
		map.remove(name); //name 키값에 해당하는 값 제거
		System.out.println("해당 데이터의 삭제가 완료되었습니다.\n");
		
		dataChange = true;
	}
	
	//전화번호 파일로 저장
	public void backup() {
		
		ObjectOutputStream oos = null; 
		
        //객체로 저장하려면 ObjectOutputStream 필요
		try {
			//객체 저장용 출력 스트림 객체 생성
			oos = new ObjectOutputStream(new FileOutputStream("Phone.dat"));
			//map 객체를 파일로 저장
			oos.writeObject(map);
			System.out.println("저장이 완료되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//사용했던 스트림 객체 닫기
			if(oos!=null)
			try {
				oos.close();
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
		
		
	}
	
	//불러오기
	public void load() {
		try {
			//파일 읽어오고 버퍼 스트림과 연결
			FileInputStream fis = new FileInputStream("Phone.dat");
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			//역직렬화해서 가져오기
			ObjectInputStream ois = new ObjectInputStream(bis);
			map = (HashMap<String, Phones>) ois.readObject();
			
			ois.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		}
	
}

class Phones implements Serializable{ // 파일로 저장하려면 직렬화 
	
	private String name; //이름
	private String number; //전화번호
	private String major; //전공
	private String grade; //학년
	private String company; //회사

	//생성자
	public Phones(String name, String number) {
		this.name = name;
		this.number = number;
	}
	
	//생성자
	public Phones(String name, String number, String major, String grade) {
		this.name = name;
		this.number = number;
		this.major = major;
		this.grade = grade;
	}
	
	//생성자
	public Phones(String name, String number, String company) {
		this.name = name;
		this.number = number;
		this.company = company;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}

	//객체를 문자열로 변환하는 메소드
	@Override
	public String toString() {
		//전공이 null이 아니면 두번째 케이스(대학) 출력
		if(this.major!=null) {
			return "이름 : " + this.name + "\n전화번호 : " + this.number +"\n전공 : " +this.major + "\n학년 : " + this.grade;
		}
		//회사가 null이 아니면 세번째 케이스(회사) 출력
		if(this.company!=null) {
			return  "이름 : " + this.name + "\n전화번호 : " + this.number+ "\n회사 : " + this.company;
		}
		return "이름 : " + this.name + "\n전화번호 : " + this.number;
	}
	}

public class Phoneproject {
	public static void main(String[] args) throws IOException {
		
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
				manager.search(); //2 선택시 manager의 search 호출
				break;
			case 3:
				manager.delData(); //3 선택시 manager의 delData호출
				break;
			case 4:
				manager.backup(); //4 선택시 manager의 backup호출
				break;
			case 5:
				manager.load(); //5 선택시 manager의 load호출
				break;
			case 6:
				System.out.println("시스템 종료");
				return; //6 선택시 시스템 종료
			default:
				System.out.println("잘못 선택하셨습니다.");
				break; //잘못 선택시 잘못 선택하셨습니다. 출력
			}
		}
	}

}