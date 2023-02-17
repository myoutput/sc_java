package Day13;

//Student 클래스
class Student {	
	int studentId; //학생의 아이디
	String studentName; //학생의 이름

	//Student 객체
	public Student(int studentId, String studentName) {
		this.studentId = studentId; //입력받은 studentId를 기존의 studentId에 대입
		this.studentName = studentName; //입력받은 studentName을 기존의 studentName에 대입
	}
	
	//toString()
	public String toString() {
		//Student 객체를 문자열로 리턴
		return "ID : "+studentId+", Name : "+studentName;
	}

	//객체 비교를 위해 Object의 equals 오버라이딩
	public boolean equals(Object obj) {
		if(obj instanceof Student) { //다운캐스팅
			Student std = (Student) obj; 
			//studentId와 std.studentId가 같고, studentName과 std.studentName이 같으면
			if(studentId == std.studentId && studentName == std.studentName)
				return true; //true 리턴
			else return false; //아니면 false 리턴
			}
		return false;
		}
	}


public class EqualsTest {

	public static void main(String[] args) {
		Student std1 = new Student(1001, "이상");
		Student std2 = new Student(1001, "이상");
		
		System.out.println("std1의 "+std1.toString()); //객체 출력
		System.out.println("std2의 "+std2.toString()); //객체 출력
		
		//std1과 std2의 주소가 같다면
		if(std1 == std2) {
			System.out.println("std1와 stu2의 주소는 같습니다.");}
		//주소가 다르다면
		else {
			System.out.println("st1와 std2의 주소는 다릅니다.");}
		//객체를 비교해 내용이 같으면
		if(std1.equals(std2)) {
			System.out.println("std1와 std2는 동일합니다.");}
		//다르다면
		else {
			System.out.println("std1와 std2는 동일하지 않습니다.");}

		
		
	}

}
