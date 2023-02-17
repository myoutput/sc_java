//package Day12;
//
//import java.util.Scanner;
//
////Phone2 클래스
//class Phone2{
//	String name;
//	String number;
//	public Phone2(String name, String number) {
//		this.name = name;
//		this.number = number;
//	}
//	public void show() {
//		System.out.println("이름 : "+name);
//		System.out.println("전화번호 : "+number);
//	}
//}
//
//class PhoneUniv2 extends Phone2{
//	String major;
//	String grade;
//
//	public PhoneUniv2(String name, String number,String major,String grade) {
//		super(name, number);
//		this.major = major;
//		this.grade = grade;
//	}
//
//	public void show() {
//		super.show();
//		System.out.println("전공 : "+major);
//		System.out.println("학년 : "+grade);
//	}
//}
//
//class PhoneComp2 extends Phone2{
//	String company;
//
//	public PhoneComp2(String name, String number, String company) {
//		super(name, number);
//		this.company = company;
//	}
//
//	public void show() {
//		super.show();
//		System.out.println("회사명 : "+company);
//	}
//
//}
//
//class PhoneManager2{
//	final int MAX = 100;
//	Phone2[] registPhone = new Phone2[MAX];
//	int count = 0;
//	Scanner sc = new Scanner(System.in);
//	public static void show() {
//		System.out.println("번호를 선택하시오.");
//		System.out.println("1. 데이터 입력");
//		System.out.println("2. 데이터 검색");
//		System.out.println("3. 데이터 삭제");
//		System.out.println("4. 프로그램 종료");
//	}
//	
//	private Phone2 inFriendData() {
//		System.out.print("이름 : ");
//		String name = sc.nextLine();
//		System.out.print("전화번호 : ");
//		String number = sc.nextLine();
//		return new Phone2(name,number);
//	}
//	
//	private Phone2 inUnivData() {
//		System.out.print("이름 : ");
//		String name = sc.nextLine();
//		System.out.print("전화번호 : ");
//		String number = sc.nextLine();
//		System.out.print("전공 : ");
//		String major = sc.nextLine();
//		System.out.print("학년 : ");
//		String grade = sc.nextLine();
//		return new PhoneUniv2(name,number,major,grade);
//	}
//	
//	private Phone2 inCompanyData() {
//		System.out.print("이름 : ");
//		String name = sc.nextLine();
//		System.out.print("전화번호 : ");
//		String number = sc.nextLine();
//		System.out.print("회사명 : ");
//		String company = sc.nextLine();
//		return new PhoneComp2(name,number,company);
//	}
//	
//	public void input() {
//		Phone2 info = null;
//		System.out.println("데이터 입력을 시작합니다..");
//		System.out.println("1. 일반, 2. 대학, 3. 회사");
//		System.out.print("선택>> ");
//		int choice = sc.nextInt();
//		
//		sc.nextLine();
//		
//		switch(choice) {
//		case 1:
//			info = inFriendData(); 
//			break;
//		case 2:
//			info = inUnivData();
//			break;
//		case 3:
//			info = inCompanyData();
//			break;
//		}
//		registPhone[count] = info;
//		System.out.println("입력이 완료되었습니다.");
//		count ++;
//	}
//	
//	public void searchData() {
//		System.out.println("검색을 시작합니다.");
//		System.out.print("이름 : ");
//		String name = sc.nextLine();
//		int indx = search(name);
//		if(indx < 0) {
//			System.out.println("해당 이름의 자료가 없습니다.\n");
//		}
//		else {
//			registPhone[indx].show();
//			System.out.println("검색하였습니다.\n");
//		}
//	}
//
//	private int search(String name) {
//		for(int idx=0;idx<count;idx++) {
//			Phone2 pointInfo = registPhone[idx];
//			if(name.compareTo(pointInfo.name)==0)
//				return idx;
//		}
//		return -1;
//	}
//	
//	public void delData() {
//		System.out.print("삭제하실 분의 이름을 입력해주세요: ");
//		String name = sc.nextLine();
//		int indx = search(name);
//		if(indx<0) {
//			System.out.println("해당 이름의 자료가 없습니다.\n");
//		}
//		else {
//			for(int idx = indx;idx<count;idx++) {
//				registPhone[idx] = registPhone[idx+1];
//				count--;
//			}
//		}
//	}
//}
//
//public class PhoneBook{
//
//	public static void main(String[] args) {
//		
//		PhoneManager2 manager = new PhoneManager2();
//
//		while(true) {
//			manager.show();
//			int n = manager.sc.nextInt();
//			manager.sc.nextLine();
//
//			switch(n) {
//			case 1:
//				manager.input();
//				
//				break;
//			case 2:
//				manager.searchData();
//				break;
//			case 3:
//				manager.delData();
//				break;
//			case 4:
//				System.out.println("시스템 종료");
//				return;
//			default:
//				System.out.println("잘못 선택하셨습니다.");
//				break;
//			}
//
//			
//		}
//
//	}
//
//
//}
