package Day20;

import java.util.Iterator;
import java.util.TreeMap;


class Member implements Comparable<Member> {
	int ID; //ID
	String name; //이름

	//Member 생성자
	public Member(int ID, String name) {
		this.ID = ID; //받은 ID를 ID에 대입
		this.name = name; //받은 name을 name에 대입
	}

	public void setMemberId(int ID) {
		this.ID = ID;
	}
	
	//Id를 리턴하는 메소드
	public int getMemberId() {
		return ID;
	}

	// 객체를 문자열로 변환하는 메소드
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
	public boolean equals(Object obj) {
		if(obj instanceof Member) { //o가 Member의 클래스인지 확인
			Member member = (Member)obj; //Member 클래스로 다운캐스팅
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

//트리맵
class MemberTreeMap{
	TreeMap<Integer, Member> map = new TreeMap<>();
	
	//데이터 저장
	public void addMember(Member member) {
		//지정된 ID를 이미 가지고 있으면 return 그렇지 않으면 저장
		if(map.containsKey(member.ID)) {
			return;
		}
		else {
			map.put(member.getMemberId(), member);
		}
		
	}
	
	//멤버 삭제 메소드
	public boolean removeMember(int ID) {
		//만약 ID를 가지고 입력한 ID를 가지고 있으면 삭제
		if(map.containsKey(ID)) {
			map.remove(ID);
			return true;
		}
		return false;
	}

	// 멤버 출력 메소드
	public void showAll() {
		Iterator<Integer> itr = map.keySet().iterator();
		while (itr.hasNext()) { //모든 요소 방문
			int key = itr.next(); //다음 요소 리턴
			Member member = map.get(key); //키값에 해당하는 멤버 가져오기
			System.out.println(member); //member 출력
		}
	}
	
}

public class MemberTreeMapTest {

	public static void main(String[] args) {
		MemberTreeMap memberTreeMap = new MemberTreeMap();
		
		
		//객체 만들기
		Member memberLee = new Member(102, "이순신");
		Member memberKim = new Member(101, "김유신");
		Member memberPark = new Member(103, "박효신");
//		Member memberPark2 = new Member(103,"박강현"); //덮어써지는지 확인용
		
		//객체 추가
		memberTreeMap.addMember(memberLee);
		memberTreeMap.addMember(memberKim);
		memberTreeMap.addMember(memberPark);
//		memberTreeMap.addMember(memberPark2);
		memberTreeMap.showAll(); //전체 출력

		//객체 만들기, 추가
		Member memberLee2 = new Member(100, "이몽룡");
		memberTreeMap.addMember(memberLee2);

		//102번 지우기
		memberTreeMap.removeMember(102);
		memberTreeMap.showAll(); //전체 출력

	}

}
