package Day22;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy {

	public static void Filecopy(String input,String output) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		int i;
		try {
			fis = new FileInputStream(input);
			fos = new FileOutputStream(output);
			while((i=fis.read())!=-1) {
				fos.write(i);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {fis.close();}
			catch(IOException e) {
				e.printStackTrace();
			}
			try {fos.close();}
			catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws IOException {
		Filecopy("14(a) 파일입출력.pdf","과제4_기말과제.pdf");

	}

}
