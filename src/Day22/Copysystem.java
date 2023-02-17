package Day22;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copysystem {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;

		try {

			// 파일 읽어오고 버퍼 스트림과 연결
			fis = new FileInputStream("04(a) 스레드 이진트리.pdf");
			bis = new BufferedInputStream(fis);

			// 파일 저장, 버퍼 스트림과 연결
			fos = new FileOutputStream("12(a) 제네릭.pdf");
			bos = new BufferedOutputStream(fos, 1); // 1byte 단위
			bos = new BufferedOutputStream(fos, 2048); // 2KB 단위

			int c;
			// while문을 통해 파일 전체를 읽어 화면에 출력
			while ((c = bis.read()) != -1) {
				bos.write((char) c);
			}
		} catch (Exception e) {
			e.printStackTrace(); // 예외정보 출력
		} finally {
			// 마지막에 FileInputStream, FileOutputStream, BufferedInputStream, BufferedOutputStream 닫기
			if (bis != null)
				try {
					bis.close();
				} catch (IOException e) {
				}
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
				}

			// BufferedOutputStream 이 close() 되면서 버퍼의 내용을 출력
			if (bos != null)
				try {
					bos.close();
				} catch (IOException e) {
				}
			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {
				}
		}

	}

}
