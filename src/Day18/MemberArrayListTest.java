package Day18;

import java.util.ArrayList;
import java.util.Iterator;

//Member 클래스
class Member{
	int ID; //ID
	String name; //이름
	
	//Member 생성자
	public Member(int ID,String name) {
		this.ID = ID; //받은 ID를 ID에 대입
		this.name = name; //받은 name을 name에 대입
	}
	
	//Id를 받아오는 메소드
	public int getMemberId() {
		return ID;
	}

	//객체를 문자열로 변환하는 메소드
	public String toString() {
		return name + "회원님의 아이디는 " + ID + "입니다.";
	}
	
}

//MemberArrayList 클래스
class MemberArrayList{
	
	//ArrayList 선언
	ArrayList<Member> arraylist = new ArrayList<Member>();
	
	//멤버 추가 메소드
	public void addMember(Member member) {
		arraylist.add(member);
	}
	
	//맴버 삭제 메소드
	public boolean removeMember(int ID) {
		//arraylist의 크기 만큼 반복문을 돌려 객체 삭제
//		for(int i = 0;i<arraylist.size();i++) {
//			Member member = arraylist.get(i); //arraylist의 객체를 차례로 꺼냄
//			//member의 ID와 받은 ID가 같으면 삭제
//			if(ID == member.getMemberId()) {
//				arraylist.remove(i);
//				return true;
//			}
//		}
//		return false;
		
		Iterator <Member> itr = arraylist.iterator();
		while(itr.hasNext()) {
			Member member = itr.next();
			if(ID == member.getMemberId()) {
				arraylist.remove(member);
				return true;
			}
		}
		return false;
	}
	
	//멤버 출력 메소드
	public void showAll() {
		//for문을 이용해 member 출력
		for(int i =0;i<arraylist.size();i++) {
			Member member = arraylist.get(i);
			System.out.println(member);
		}
		System.out.println();
        System.out.println(arraylist); //arraylist 출력
        System.out.println();
	}
}

public class MemberArrayListTest {

	public static void main(String[] args) {
		
		MemberArrayList memberArrayList = new MemberArrayList();
		
		//객체 만들기
		Member memberLee = new Member(101, "이순신");
		Member memberKim = new Member(102, "김유신");
		Member memberPark = new Member(103, "박신양");
		Member memberPark2 = new Member(103, "박신양");
		
		//arraylist에 객체 추가
		memberArrayList.addMember(memberLee);
		memberArrayList.addMember(memberKim);
		memberArrayList.addMember(memberPark);
		memberArrayList.addMember(memberPark2);
		
		memberArrayList.showAll(); //전체 출력
		
		//객체 삭제
		memberArrayList.removeMember(memberKim.getMemberId());
		memberArrayList.showAll(); //전체 출력

	}

}