package Day19;

import java.util.Iterator;
import java.util.TreeSet;

//Member 클래스
class Member implements Comparable<Member> {
	int ID; //ID
	String name; //이름

	//Member 생성자
	public Member(int ID, String name) {
		this.ID = ID; //받은 ID를 ID에 대입
		this.name = name; //받은 name을 name에 대입
	}
	
	//ID를 리턴하는 getMemberId 메소드
	public int getMemberId() {
		return ID;
	}

	//객체를 문자열로 변환하는 메소드
	public String toString() {
		return name + "회원님의 아이디는 " + ID + "입니다.";
	}
	
	//hashCode 오버라이딩(이 메소드가 아이디를 반환하도록 재정의함)
	@Override
	public int hashCode() {
		return ID;
	}
	
	//equals 오버라이딩
	@Override
	public boolean equals(Object o) {
		if(o instanceof Member) { //o가 Member의 클래스인지 확인
			Member member = (Member)o; //Member 클래스로 다운캐스팅
			//같은 값이 있으면 리턴 true 없으면 false 리턴
			if(this.ID == member.ID) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}

	//오름차순으로 정렬
	@Override
	public int compareTo(Member o) {
		return(this.ID - o.ID);
	}

}

class MemberTreeSet {

	TreeSet<Member> tree = new TreeSet<Member>();

	//멤버 추가 메소드
	public void addMember(Member member) {
		tree.add(member);
	}

	//맴버 삭제 메소드
	public boolean removeMember(int ID) {
		Iterator<Member> itr = tree.iterator();
		while (itr.hasNext()) { //모든 요소 방문
			Member member = itr.next(); //다음 요소 리턴
			//받은 ID와 member안에 있는 Id와 같으면 제거
			if (ID == member.getMemberId()) {
				tree.remove(member);
				return true;
			}
		}
		return false;
	}

	//멤버 출력 메소드
	public void showAll() {
		Iterator<Member> itr = tree.iterator();
		while (itr.hasNext()) { //모든 요소 방문
			Member member = itr.next(); //다음 요소 리턴
			System.out.println(member); //member 출력
		}
		System.out.println();
	}
}


public class MemberTreeSetTest {

	public static void main(String[] args) {
		MemberTreeSet memberTreeSet = new MemberTreeSet();

		//객체 만들기
		Member memberLee = new Member(101, "이순신");
		Member memberKim = new Member(102, "김유신");
		Member memberPark = new Member(103, "박효신");

		//객체 추가
		memberTreeSet.addMember(memberLee);
		memberTreeSet.addMember(memberKim);
		memberTreeSet.addMember(memberPark);

		memberTreeSet.showAll(); //전체 출력

		//객체 만들고 추가
		Member memberLee2 = new Member(100, "이몽룡");
		memberTreeSet.addMember(memberLee2);

		memberTreeSet.showAll(); //전체 출력

		memberTreeSet.removeMember(100); //삭제
		memberTreeSet.showAll(); //전체 출력

	}
}
