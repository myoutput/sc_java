package Day22;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//Member 클래스
class Member implements Serializable{
	private int ID;
	private String name;
	
	//Member 생성자
	public Member(int ID, String name) {
		this.ID = ID; //받은 ID를 ID에 대입
		this.name = name; //받은 name을 name에 대입
	}
	
	public String getMemberName() {
		return name;
	}
	
	//Id를 리턴하는 메소드
	public int getMemberId() {
		return ID;
	}
	
	// 객체를 문자열로 변환하는 메소드
	public String toString() {
		return this.name + "회원님의 아이디는 " + this.ID + "입니다.";
	}
	
	
}

public class Serializablee {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//객체 만들기
		Member memberLee = new Member(102, "Lee");
		Member memberKim = new Member(101, "Kim");
		Member memberPark = new Member(103, "Park");
		
		//쓰기
		//member라는 텍스트파일에 저장
		FileOutputStream fos = new FileOutputStream("member.txt");
        //객체 직렬화
		ObjectOutputStream oos = new ObjectOutputStream(fos);
        //oos에 객체 받기
		oos.writeObject(memberLee); 
        oos.writeObject(memberKim);
        oos.writeObject(memberPark);
        oos.close(); //oos 닫기
        
        //읽기
        //member라는 텍스트파일 불러옴
		FileInputStream fis=new FileInputStream("member.txt");
		//역직렬화
		ObjectInputStream ojs=new ObjectInputStream(fis);
		//Member 타입으로 읽기
		Member Lee =(Member)ojs.readObject();
		Member Kim = (Member)ojs.readObject();
		Member Park = (Member)ojs.readObject();
		ojs.close();
		
		//출력
		System.out.println(Lee);
		System.out.println(Kim);
		System.out.println(Park);
		
	}

}
