import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ToTest {

	public static void main(String[] args) throws IOException {
		PlayerData data = new PlayerData();
		
//		File file = new File("C:\\Users\\waveb\\OneDrive\\Documents\\World Cup\\standings.csv");
//		try {
//			if (file.createNewFile()){
//				System.out.println("File is created!");
//				}else{
//				System.out.println("File already exists.");
//				}
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
		
		FileWriter writer = null;
		try {
			writer = new FileWriter("standings.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.append(data.toString());
		writer.write(data.toString());
		writer.close();
	}

}
