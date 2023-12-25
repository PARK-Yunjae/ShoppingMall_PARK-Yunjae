package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import files.AdminFileLoad;

public class FileDAO {
	String CUR_PATH = System.getProperty("user.dir") + "//src//" + AdminFileLoad.class.getPackageName() + "//";

	public void FileSave(String fileName, String data) {
		try (FileWriter fw = new FileWriter(CUR_PATH + fileName)) {
			fw.write(data);
			System.out.println(fileName + " 저장 성공");
		} catch (Exception e) {
			System.out.println(fileName + " 저장 실패");
		}
	}

	public String FileLoad(String fileName) {
		String data = "";
		try (FileReader fr = new FileReader(CUR_PATH + fileName); 
			BufferedReader br = new BufferedReader(fr)) {
			while(true) {
				String line = br.readLine();
				if(line == null) {
					break;
				}
				data += line + "\n";
			}
			if(data.length() != 0) {
				data = data.substring(0, data.length()-1);
			}
			System.out.println(fileName + " 로드 성공");
		} catch (Exception e) {
			System.out.println(fileName + " 로드 실패");
		}
		return data;
	}
}
